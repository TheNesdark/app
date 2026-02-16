package com.genoma.plus.jpa.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/jpa/entity/NominaNovedadesEncabezado_1.class */
@Table(name = "rh_nomina_novedades")
@Entity
public class NominaNovedadesEncabezado_1 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate fechaD;

    @Column
    private Integer idTercero;

    @Column
    private LocalDate fecha;

    @Column(name = "usuarioS")
    private String usuario;

    @Column
    private Integer idPeriodo;

    @OneToMany(mappedBy = "nominaNovedadesEncabezado", cascade = {CascadeType.PERSIST})
    private List<NominaNovedadesDetalle> listaDetalle;

    @Generated
    public NominaNovedadesEncabezado_1(Long id, LocalDate fechaD, Integer idTercero, LocalDate fecha, String usuario, Integer idPeriodo, List<NominaNovedadesDetalle> listaDetalle) {
        this.id = id;
        this.fechaD = fechaD;
        this.idTercero = idTercero;
        this.fecha = fecha;
        this.usuario = usuario;
        this.idPeriodo = idPeriodo;
        this.listaDetalle = listaDetalle;
    }

    @Generated
    public NominaNovedadesEncabezado_1() {
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/jpa/entity/NominaNovedadesEncabezado_1$NominaNovedadesEncabezado_1Builder.class */
    @Generated
    public static class NominaNovedadesEncabezado_1Builder {

        @Generated
        private Long id;

        @Generated
        private LocalDate fechaD;

        @Generated
        private Integer idTercero;

        @Generated
        private LocalDate fecha;

        @Generated
        private String usuario;

        @Generated
        private Integer idPeriodo;

        @Generated
        private List<NominaNovedadesDetalle> listaDetalle;

        @Generated
        NominaNovedadesEncabezado_1Builder() {
        }

        @Generated
        public NominaNovedadesEncabezado_1Builder id(Long id) {
            this.id = id;
            return this;
        }

        @Generated
        public NominaNovedadesEncabezado_1Builder fechaD(LocalDate fechaD) {
            this.fechaD = fechaD;
            return this;
        }

        @Generated
        public NominaNovedadesEncabezado_1Builder idTercero(Integer idTercero) {
            this.idTercero = idTercero;
            return this;
        }

        @Generated
        public NominaNovedadesEncabezado_1Builder fecha(LocalDate fecha) {
            this.fecha = fecha;
            return this;
        }

        @Generated
        public NominaNovedadesEncabezado_1Builder usuario(String usuario) {
            this.usuario = usuario;
            return this;
        }

        @Generated
        public NominaNovedadesEncabezado_1Builder idPeriodo(Integer idPeriodo) {
            this.idPeriodo = idPeriodo;
            return this;
        }

        @Generated
        public NominaNovedadesEncabezado_1Builder listaDetalle(List<NominaNovedadesDetalle> listaDetalle) {
            this.listaDetalle = listaDetalle;
            return this;
        }

        @Generated
        public NominaNovedadesEncabezado_1 build() {
            return new NominaNovedadesEncabezado_1(this.id, this.fechaD, this.idTercero, this.fecha, this.usuario, this.idPeriodo, this.listaDetalle);
        }

        @Generated
        public String toString() {
            return "NominaNovedadesEncabezado_1.NominaNovedadesEncabezado_1Builder(id=" + this.id + ", fechaD=" + this.fechaD + ", idTercero=" + this.idTercero + ", fecha=" + this.fecha + ", usuario=" + this.usuario + ", idPeriodo=" + this.idPeriodo + ", listaDetalle=" + this.listaDetalle + ")";
        }
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setFechaD(LocalDate fechaD) {
        this.fechaD = fechaD;
    }

    @Generated
    public void setIdTercero(Integer idTercero) {
        this.idTercero = idTercero;
    }

    @Generated
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Generated
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Generated
    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    @Generated
    public void setListaDetalle(List<NominaNovedadesDetalle> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    @Generated
    public static NominaNovedadesEncabezado_1Builder builder() {
        return new NominaNovedadesEncabezado_1Builder();
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public LocalDate getFechaD() {
        return this.fechaD;
    }

    @Generated
    public Integer getIdTercero() {
        return this.idTercero;
    }

    @Generated
    public LocalDate getFecha() {
        return this.fecha;
    }

    @Generated
    public String getUsuario() {
        return this.usuario;
    }

    @Generated
    public Integer getIdPeriodo() {
        return this.idPeriodo;
    }

    @Generated
    public List<NominaNovedadesDetalle> getListaDetalle() {
        return this.listaDetalle;
    }
}
