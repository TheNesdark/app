package com.genoma.plus.jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Generated;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/jpa/entity/NominaNovedadesDetalle_1.class */
@Table(name = "rh_nomina_novedades_detalle")
@Entity
public class NominaNovedadesDetalle_1 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idEncabezado", nullable = false)
    @Cascade({CascadeType.ALL})
    private NominaNovedadesEncabezado nominaNovedadesEncabezado;

    @Column
    private Integer idConcepto;

    @Column
    private Integer cantidad;

    @Column
    private LocalTime horaInicio;

    @Column
    private LocalTime horaFin;

    @Column
    private Boolean estado;

    @Column
    private Boolean verificado;

    @Column
    private LocalDate fechaD;

    @Column
    private LocalDate fechaInicio;

    @Column
    LocalDate fechaFin;

    @Column
    private Double valor;

    @Generated
    public NominaNovedadesDetalle_1(Long id, NominaNovedadesEncabezado nominaNovedadesEncabezado, Integer idConcepto, Integer cantidad, LocalTime horaInicio, LocalTime horaFin, Boolean estado, Boolean verificado, LocalDate fechaD, LocalDate fechaInicio, LocalDate fechaFin, Double valor) {
        this.id = id;
        this.nominaNovedadesEncabezado = nominaNovedadesEncabezado;
        this.idConcepto = idConcepto;
        this.cantidad = cantidad;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estado = estado;
        this.verificado = verificado;
        this.fechaD = fechaD;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.valor = valor;
    }

    @Generated
    public NominaNovedadesDetalle_1() {
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/jpa/entity/NominaNovedadesDetalle_1$NominaNovedadesDetalle_1Builder.class */
    @Generated
    public static class NominaNovedadesDetalle_1Builder {

        @Generated
        private Long id;

        @Generated
        private NominaNovedadesEncabezado nominaNovedadesEncabezado;

        @Generated
        private Integer idConcepto;

        @Generated
        private Integer cantidad;

        @Generated
        private LocalTime horaInicio;

        @Generated
        private LocalTime horaFin;

        @Generated
        private Boolean estado;

        @Generated
        private Boolean verificado;

        @Generated
        private LocalDate fechaD;

        @Generated
        private LocalDate fechaInicio;

        @Generated
        private LocalDate fechaFin;

        @Generated
        private Double valor;

        @Generated
        NominaNovedadesDetalle_1Builder() {
        }

        @Generated
        public NominaNovedadesDetalle_1Builder id(Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public NominaNovedadesDetalle_1Builder nominaNovedadesEncabezado(NominaNovedadesEncabezado nominaNovedadesEncabezado) {
            this.nominaNovedadesEncabezado = nominaNovedadesEncabezado;
            return this;
        }

        @Generated
        public NominaNovedadesDetalle_1Builder idConcepto(Integer idConcepto) {
            this.idConcepto = idConcepto;
            return this;
        }

        @Generated
        public NominaNovedadesDetalle_1Builder cantidad(Integer cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        @Generated
        public NominaNovedadesDetalle_1Builder horaInicio(LocalTime horaInicio) {
            this.horaInicio = horaInicio;
            return this;
        }

        @Generated
        public NominaNovedadesDetalle_1Builder horaFin(LocalTime horaFin) {
            this.horaFin = horaFin;
            return this;
        }

        @Generated
        public NominaNovedadesDetalle_1Builder estado(Boolean estado) {
            this.estado = estado;
            return this;
        }

        @Generated
        public NominaNovedadesDetalle_1Builder verificado(Boolean verificado) {
            this.verificado = verificado;
            return this;
        }

        @Generated
        public NominaNovedadesDetalle_1Builder fechaD(LocalDate fechaD) {
            this.fechaD = fechaD;
            return this;
        }

        @Generated
        public NominaNovedadesDetalle_1Builder fechaInicio(LocalDate fechaInicio) {
            this.fechaInicio = fechaInicio;
            return this;
        }

        @Generated
        public NominaNovedadesDetalle_1Builder fechaFin(LocalDate fechaFin) {
            this.fechaFin = fechaFin;
            return this;
        }

        @Generated
        public NominaNovedadesDetalle_1Builder valor(Double valor) {
            this.valor = valor;
            return this;
        }

        @Generated
        public NominaNovedadesDetalle_1 build() {
            return new NominaNovedadesDetalle_1(this.id, this.nominaNovedadesEncabezado, this.idConcepto, this.cantidad, this.horaInicio, this.horaFin, this.estado, this.verificado, this.fechaD, this.fechaInicio, this.fechaFin, this.valor);
        }

        @Generated
        public String toString() {
            return "NominaNovedadesDetalle_1.NominaNovedadesDetalle_1Builder(id=" + this.id + ", nominaNovedadesEncabezado=" + this.nominaNovedadesEncabezado + ", idConcepto=" + this.idConcepto + ", cantidad=" + this.cantidad + ", horaInicio=" + this.horaInicio + ", horaFin=" + this.horaFin + ", estado=" + this.estado + ", verificado=" + this.verificado + ", fechaD=" + this.fechaD + ", fechaInicio=" + this.fechaInicio + ", fechaFin=" + this.fechaFin + ", valor=" + this.valor + ")";
        }
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setNominaNovedadesEncabezado(NominaNovedadesEncabezado nominaNovedadesEncabezado) {
        this.nominaNovedadesEncabezado = nominaNovedadesEncabezado;
    }

    @Generated
    public void setIdConcepto(Integer idConcepto) {
        this.idConcepto = idConcepto;
    }

    @Generated
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Generated
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    @Generated
    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    @Generated
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Generated
    public void setVerificado(Boolean verificado) {
        this.verificado = verificado;
    }

    @Generated
    public void setFechaD(LocalDate fechaD) {
        this.fechaD = fechaD;
    }

    @Generated
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Generated
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Generated
    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Generated
    public static NominaNovedadesDetalle_1Builder builder() {
        return new NominaNovedadesDetalle_1Builder();
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public NominaNovedadesEncabezado getNominaNovedadesEncabezado() {
        return this.nominaNovedadesEncabezado;
    }

    @Generated
    public Integer getIdConcepto() {
        return this.idConcepto;
    }

    @Generated
    public Integer getCantidad() {
        return this.cantidad;
    }

    @Generated
    public LocalTime getHoraInicio() {
        return this.horaInicio;
    }

    @Generated
    public LocalTime getHoraFin() {
        return this.horaFin;
    }

    @Generated
    public Boolean getEstado() {
        return this.estado;
    }

    @Generated
    public Boolean getVerificado() {
        return this.verificado;
    }

    @Generated
    public LocalDate getFechaD() {
        return this.fechaD;
    }

    @Generated
    public LocalDate getFechaInicio() {
        return this.fechaInicio;
    }

    @Generated
    public LocalDate getFechaFin() {
        return this.fechaFin;
    }

    @Generated
    public Double getValor() {
        return this.valor;
    }
}
