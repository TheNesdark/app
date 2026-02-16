package com.genoma.plus.controller.general.dto;

import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/dto/ReportePyPDTO.class */
public class ReportePyPDTO {
    private Integer id;
    private String name;
    private String sql;
    private String formerSQL;
    private String assigned;
    private Integer idModule;
    private Boolean state;
    private Integer order;

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/dto/ReportePyPDTO$ReportePyPDTOBuilder.class */
    @Generated
    public static class ReportePyPDTOBuilder {

        @Generated
        private Integer id;

        @Generated
        private String name;

        @Generated
        private String sql;

        @Generated
        private String formerSQL;

        @Generated
        private String assigned;

        @Generated
        private Integer idModule;

        @Generated
        private Boolean state;

        @Generated
        private Integer order;

        @Generated
        ReportePyPDTOBuilder() {
        }

        @Generated
        public ReportePyPDTOBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        @Generated
        public ReportePyPDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        @Generated
        public ReportePyPDTOBuilder sql(String sql) {
            this.sql = sql;
            return this;
        }

        @Generated
        public ReportePyPDTOBuilder formerSQL(String formerSQL) {
            this.formerSQL = formerSQL;
            return this;
        }

        @Generated
        public ReportePyPDTOBuilder assigned(String assigned) {
            this.assigned = assigned;
            return this;
        }

        @Generated
        public ReportePyPDTOBuilder idModule(Integer idModule) {
            this.idModule = idModule;
            return this;
        }

        @Generated
        public ReportePyPDTOBuilder state(Boolean state) {
            this.state = state;
            return this;
        }

        @Generated
        public ReportePyPDTOBuilder order(Integer order) {
            this.order = order;
            return this;
        }

        @Generated
        public ReportePyPDTO build() {
            return new ReportePyPDTO(this.id, this.name, this.sql, this.formerSQL, this.assigned, this.idModule, this.state, this.order);
        }

        @Generated
        public String toString() {
            return "ReportePyPDTO.ReportePyPDTOBuilder(id=" + this.id + ", name=" + this.name + ", sql=" + this.sql + ", formerSQL=" + this.formerSQL + ", assigned=" + this.assigned + ", idModule=" + this.idModule + ", state=" + this.state + ", order=" + this.order + ")";
        }
    }

    @Generated
    public static ReportePyPDTOBuilder builder() {
        return new ReportePyPDTOBuilder();
    }

    @Generated
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated
    public void setName(String name) {
        this.name = name;
    }

    @Generated
    public void setSql(String sql) {
        this.sql = sql;
    }

    @Generated
    public void setFormerSQL(String formerSQL) {
        this.formerSQL = formerSQL;
    }

    @Generated
    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    @Generated
    public void setIdModule(Integer idModule) {
        this.idModule = idModule;
    }

    @Generated
    public void setState(Boolean state) {
        this.state = state;
    }

    @Generated
    public void setOrder(Integer order) {
        this.order = order;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ReportePyPDTO)) {
            return false;
        }
        ReportePyPDTO other = (ReportePyPDTO) o;
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
        Object this$idModule = getIdModule();
        Object other$idModule = other.getIdModule();
        if (this$idModule == null) {
            if (other$idModule != null) {
                return false;
            }
        } else if (!this$idModule.equals(other$idModule)) {
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
        Object this$order = getOrder();
        Object other$order = other.getOrder();
        if (this$order == null) {
            if (other$order != null) {
                return false;
            }
        } else if (!this$order.equals(other$order)) {
            return false;
        }
        Object this$name = getName();
        Object other$name = other.getName();
        if (this$name == null) {
            if (other$name != null) {
                return false;
            }
        } else if (!this$name.equals(other$name)) {
            return false;
        }
        Object this$sql = getSql();
        Object other$sql = other.getSql();
        if (this$sql == null) {
            if (other$sql != null) {
                return false;
            }
        } else if (!this$sql.equals(other$sql)) {
            return false;
        }
        Object this$formerSQL = getFormerSQL();
        Object other$formerSQL = other.getFormerSQL();
        if (this$formerSQL == null) {
            if (other$formerSQL != null) {
                return false;
            }
        } else if (!this$formerSQL.equals(other$formerSQL)) {
            return false;
        }
        Object this$assigned = getAssigned();
        Object other$assigned = other.getAssigned();
        return this$assigned == null ? other$assigned == null : this$assigned.equals(other$assigned);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof ReportePyPDTO;
    }

    @Generated
    public int hashCode() {
        Object $id = getId();
        int result = (1 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $idModule = getIdModule();
        int result2 = (result * 59) + ($idModule == null ? 43 : $idModule.hashCode());
        Object $state = getState();
        int result3 = (result2 * 59) + ($state == null ? 43 : $state.hashCode());
        Object $order = getOrder();
        int result4 = (result3 * 59) + ($order == null ? 43 : $order.hashCode());
        Object $name = getName();
        int result5 = (result4 * 59) + ($name == null ? 43 : $name.hashCode());
        Object $sql = getSql();
        int result6 = (result5 * 59) + ($sql == null ? 43 : $sql.hashCode());
        Object $formerSQL = getFormerSQL();
        int result7 = (result6 * 59) + ($formerSQL == null ? 43 : $formerSQL.hashCode());
        Object $assigned = getAssigned();
        return (result7 * 59) + ($assigned == null ? 43 : $assigned.hashCode());
    }

    @Generated
    public String toString() {
        return "ReportePyPDTO(id=" + getId() + ", name=" + getName() + ", sql=" + getSql() + ", formerSQL=" + getFormerSQL() + ", assigned=" + getAssigned() + ", idModule=" + getIdModule() + ", state=" + getState() + ", order=" + getOrder() + ")";
    }

    @Generated
    public ReportePyPDTO() {
    }

    @Generated
    public ReportePyPDTO(Integer id, String name, String sql, String formerSQL, String assigned, Integer idModule, Boolean state, Integer order) {
        this.id = id;
        this.name = name;
        this.sql = sql;
        this.formerSQL = formerSQL;
        this.assigned = assigned;
        this.idModule = idModule;
        this.state = state;
        this.order = order;
    }

    @Generated
    public Integer getId() {
        return this.id;
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public String getSql() {
        return this.sql;
    }

    @Generated
    public String getFormerSQL() {
        return this.formerSQL;
    }

    @Generated
    public String getAssigned() {
        return this.assigned;
    }

    @Generated
    public Integer getIdModule() {
        return this.idModule;
    }

    @Generated
    public Boolean getState() {
        return this.state;
    }

    @Generated
    public Integer getOrder() {
        return this.order;
    }
}
