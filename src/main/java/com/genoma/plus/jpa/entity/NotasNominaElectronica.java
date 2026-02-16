package com.genoma.plus.jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/jpa/entity/NotasNominaElectronica.class */
@Table(name = "rh_nota_nomina_electronica")
@Entity
public class NotasNominaElectronica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String noNomina;

    @Column
    private Long consecutivo;

    @Column
    private String cune;

    @Column
    private Boolean estado;

    @Column
    private LocalDate fecha;

    @Generated
    public NotasNominaElectronica(Long id, String noNomina, Long consecutivo, String cune, Boolean estado, LocalDate fecha) {
        this.id = id;
        this.noNomina = noNomina;
        this.consecutivo = consecutivo;
        this.cune = cune;
        this.estado = estado;
        this.fecha = fecha;
    }

    @Generated
    public NotasNominaElectronica() {
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/jpa/entity/NotasNominaElectronica$NotasNominaElectronicaBuilder.class */
    @Generated
    public static class NotasNominaElectronicaBuilder {

        @Generated
        private Long id;

        @Generated
        private String noNomina;

        @Generated
        private Long consecutivo;

        @Generated
        private String cune;

        @Generated
        private Boolean estado;

        @Generated
        private LocalDate fecha;

        @Generated
        NotasNominaElectronicaBuilder() {
        }

        @Generated
        public NotasNominaElectronicaBuilder id(Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public NotasNominaElectronicaBuilder noNomina(String noNomina) {
            this.noNomina = noNomina;
            return this;
        }

        @Generated
        public NotasNominaElectronicaBuilder consecutivo(Long consecutivo) {
            this.consecutivo = consecutivo;
            return this;
        }

        @Generated
        public NotasNominaElectronicaBuilder cune(String cune) {
            this.cune = cune;
            return this;
        }

        @Generated
        public NotasNominaElectronicaBuilder estado(Boolean estado) {
            this.estado = estado;
            return this;
        }

        @Generated
        public NotasNominaElectronicaBuilder fecha(LocalDate fecha) {
            this.fecha = fecha;
            return this;
        }

        @Generated
        public NotasNominaElectronica build() {
            return new NotasNominaElectronica(this.id, this.noNomina, this.consecutivo, this.cune, this.estado, this.fecha);
        }

        @Generated
        public String toString() {
            return "NotasNominaElectronica.NotasNominaElectronicaBuilder(id=" + this.id + ", noNomina=" + this.noNomina + ", consecutivo=" + this.consecutivo + ", cune=" + this.cune + ", estado=" + this.estado + ", fecha=" + this.fecha + ")";
        }
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setNoNomina(String noNomina) {
        this.noNomina = noNomina;
    }

    @Generated
    public void setConsecutivo(Long consecutivo) {
        this.consecutivo = consecutivo;
    }

    @Generated
    public void setCune(String cune) {
        this.cune = cune;
    }

    @Generated
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Generated
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Generated
    public static NotasNominaElectronicaBuilder builder() {
        return new NotasNominaElectronicaBuilder();
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public String getNoNomina() {
        return this.noNomina;
    }

    @Generated
    public Long getConsecutivo() {
        return this.consecutivo;
    }

    @Generated
    public String getCune() {
        return this.cune;
    }

    @Generated
    public Boolean getEstado() {
        return this.estado;
    }

    @Generated
    public LocalDate getFecha() {
        return this.fecha;
    }
}
