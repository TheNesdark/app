package com.genoma.plus.dao.impl.parametrizacion;

import java.time.LocalDateTime;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/parametrizacion/TypeDestinyDomain.class */
public class TypeDestinyDomain {
    private Integer Id;
    private String Name;
    private Boolean State;
    private LocalDateTime Date;
    private Integer idUserRh;
    private Integer idRips;
    private String Code;

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TypeDestinyDomain)) {
            return false;
        }
        TypeDestinyDomain other = (TypeDestinyDomain) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$Id = getId();
        Object other$Id = other.getId();
        if (this$Id == null) {
            if (other$Id != null) {
                return false;
            }
        } else if (!this$Id.equals(other$Id)) {
            return false;
        }
        Object this$State = getState();
        Object other$State = other.getState();
        if (this$State == null) {
            if (other$State != null) {
                return false;
            }
        } else if (!this$State.equals(other$State)) {
            return false;
        }
        Object this$idUserRh = getIdUserRh();
        Object other$idUserRh = other.getIdUserRh();
        if (this$idUserRh == null) {
            if (other$idUserRh != null) {
                return false;
            }
        } else if (!this$idUserRh.equals(other$idUserRh)) {
            return false;
        }
        Object this$idRips = getIdRips();
        Object other$idRips = other.getIdRips();
        if (this$idRips == null) {
            if (other$idRips != null) {
                return false;
            }
        } else if (!this$idRips.equals(other$idRips)) {
            return false;
        }
        Object this$Name = getName();
        Object other$Name = other.getName();
        if (this$Name == null) {
            if (other$Name != null) {
                return false;
            }
        } else if (!this$Name.equals(other$Name)) {
            return false;
        }
        Object this$Date = getDate();
        Object other$Date = other.getDate();
        if (this$Date == null) {
            if (other$Date != null) {
                return false;
            }
        } else if (!this$Date.equals(other$Date)) {
            return false;
        }
        Object this$Code = getCode();
        Object other$Code = other.getCode();
        return this$Code == null ? other$Code == null : this$Code.equals(other$Code);
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof TypeDestinyDomain;
    }

    @Generated
    public int hashCode() {
        Object $Id = getId();
        int result = (1 * 59) + ($Id == null ? 43 : $Id.hashCode());
        Object $State = getState();
        int result2 = (result * 59) + ($State == null ? 43 : $State.hashCode());
        Object $idUserRh = getIdUserRh();
        int result3 = (result2 * 59) + ($idUserRh == null ? 43 : $idUserRh.hashCode());
        Object $idRips = getIdRips();
        int result4 = (result3 * 59) + ($idRips == null ? 43 : $idRips.hashCode());
        Object $Name = getName();
        int result5 = (result4 * 59) + ($Name == null ? 43 : $Name.hashCode());
        Object $Date = getDate();
        int result6 = (result5 * 59) + ($Date == null ? 43 : $Date.hashCode());
        Object $Code = getCode();
        return (result6 * 59) + ($Code == null ? 43 : $Code.hashCode());
    }

    @Generated
    public String toString() {
        return "TypeDestinyDomain(Id=" + getId() + ", Name=" + getName() + ", State=" + getState() + ", Date=" + getDate() + ", idUserRh=" + getIdUserRh() + ", idRips=" + getIdRips() + ", Code=" + getCode() + ")";
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/parametrizacion/TypeDestinyDomain$TypeDestinyDomainBuilder.class */
    @Generated
    public static class TypeDestinyDomainBuilder {

        @Generated
        private Integer Id;

        @Generated
        private String Name;

        @Generated
        private Boolean State;

        @Generated
        private LocalDateTime Date;

        @Generated
        private Integer idUserRh;

        @Generated
        private Integer idRips;

        @Generated
        private String Code;

        @Generated
        TypeDestinyDomainBuilder() {
        }

        @Generated
        public TypeDestinyDomainBuilder Id(Integer Id) {
            this.Id = Id;
            return this;
        }

        @Generated
        public TypeDestinyDomainBuilder Name(String Name) {
            this.Name = Name;
            return this;
        }

        @Generated
        public TypeDestinyDomainBuilder State(Boolean State) {
            this.State = State;
            return this;
        }

        @Generated
        public TypeDestinyDomainBuilder Date(LocalDateTime Date) {
            this.Date = Date;
            return this;
        }

        @Generated
        public TypeDestinyDomainBuilder idUserRh(Integer idUserRh) {
            this.idUserRh = idUserRh;
            return this;
        }

        @Generated
        public TypeDestinyDomainBuilder idRips(Integer idRips) {
            this.idRips = idRips;
            return this;
        }

        @Generated
        public TypeDestinyDomainBuilder Code(String Code) {
            this.Code = Code;
            return this;
        }

        @Generated
        public TypeDestinyDomain build() {
            return new TypeDestinyDomain(this.Id, this.Name, this.State, this.Date, this.idUserRh, this.idRips, this.Code);
        }

        @Generated
        public String toString() {
            return "TypeDestinyDomain.TypeDestinyDomainBuilder(Id=" + this.Id + ", Name=" + this.Name + ", State=" + this.State + ", Date=" + this.Date + ", idUserRh=" + this.idUserRh + ", idRips=" + this.idRips + ", Code=" + this.Code + ")";
        }
    }

    @Generated
    public void setId(Integer Id) {
        this.Id = Id;
    }

    @Generated
    public void setName(String Name) {
        this.Name = Name;
    }

    @Generated
    public void setState(Boolean State) {
        this.State = State;
    }

    @Generated
    public void setDate(LocalDateTime Date) {
        this.Date = Date;
    }

    @Generated
    public void setIdUserRh(Integer idUserRh) {
        this.idUserRh = idUserRh;
    }

    @Generated
    public void setIdRips(Integer idRips) {
        this.idRips = idRips;
    }

    @Generated
    public void setCode(String Code) {
        this.Code = Code;
    }

    @Generated
    public static TypeDestinyDomainBuilder builder() {
        return new TypeDestinyDomainBuilder();
    }

    @Generated
    public TypeDestinyDomain(Integer Id, String Name, Boolean State, LocalDateTime Date, Integer idUserRh, Integer idRips, String Code) {
        this.Id = Id;
        this.Name = Name;
        this.State = State;
        this.Date = Date;
        this.idUserRh = idUserRh;
        this.idRips = idRips;
        this.Code = Code;
    }

    @Generated
    public TypeDestinyDomain() {
    }

    @Generated
    public Integer getId() {
        return this.Id;
    }

    @Generated
    public String getName() {
        return this.Name;
    }

    @Generated
    public Boolean getState() {
        return this.State;
    }

    @Generated
    public LocalDateTime getDate() {
        return this.Date;
    }

    @Generated
    public Integer getIdUserRh() {
        return this.idUserRh;
    }

    @Generated
    public Integer getIdRips() {
        return this.idRips;
    }

    @Generated
    public String getCode() {
        return this.Code;
    }
}
