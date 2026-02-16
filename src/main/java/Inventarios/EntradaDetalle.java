package Inventarios;

import java.util.Date;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/EntradaDetalle.class */
class EntradaDetalle {
    private Long idSuministro;
    private Long idSuministroBodega;
    private String codigoBarra;
    private String nombre;
    private String lote;
    private Date fechaVecimiento;
    private Double cantidad;
    private Double valorUnitario;
    private Double poncentajeImpuesto;
    private Boolean acepta;
    private String observacion;
    private Long cantidadUnidad;
    private Double temperatura;
    private Double cantidadPendiente;
    private String codigoCum;
    private String codigoAtc;
    private Short cantidadMuestreo;
    private Entrada entrada;

    @Generated
    public void setIdSuministro(Long idSuministro) {
        this.idSuministro = idSuministro;
    }

    @Generated
    public void setIdSuministroBodega(Long idSuministroBodega) {
        this.idSuministroBodega = idSuministroBodega;
    }

    @Generated
    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    @Generated
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Generated
    public void setLote(String lote) {
        this.lote = lote;
    }

    @Generated
    public void setFechaVecimiento(Date fechaVecimiento) {
        this.fechaVecimiento = fechaVecimiento;
    }

    @Generated
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    @Generated
    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Generated
    public void setPoncentajeImpuesto(Double poncentajeImpuesto) {
        this.poncentajeImpuesto = poncentajeImpuesto;
    }

    @Generated
    public void setAcepta(Boolean acepta) {
        this.acepta = acepta;
    }

    @Generated
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Generated
    public void setCantidadUnidad(Long cantidadUnidad) {
        this.cantidadUnidad = cantidadUnidad;
    }

    @Generated
    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    @Generated
    public void setCantidadPendiente(Double cantidadPendiente) {
        this.cantidadPendiente = cantidadPendiente;
    }

    @Generated
    public void setCodigoCum(String codigoCum) {
        this.codigoCum = codigoCum;
    }

    @Generated
    public void setCodigoAtc(String codigoAtc) {
        this.codigoAtc = codigoAtc;
    }

    @Generated
    public void setCantidadMuestreo(Short cantidadMuestreo) {
        this.cantidadMuestreo = cantidadMuestreo;
    }

    @Generated
    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    @Generated
    public Long getIdSuministro() {
        return this.idSuministro;
    }

    @Generated
    public Long getIdSuministroBodega() {
        return this.idSuministroBodega;
    }

    @Generated
    public String getCodigoBarra() {
        return this.codigoBarra;
    }

    @Generated
    public String getNombre() {
        return this.nombre;
    }

    @Generated
    public String getLote() {
        return this.lote;
    }

    @Generated
    public Date getFechaVecimiento() {
        return this.fechaVecimiento;
    }

    @Generated
    public Double getCantidad() {
        return this.cantidad;
    }

    @Generated
    public Double getValorUnitario() {
        return this.valorUnitario;
    }

    @Generated
    public Double getPoncentajeImpuesto() {
        return this.poncentajeImpuesto;
    }

    @Generated
    public Boolean getAcepta() {
        return this.acepta;
    }

    @Generated
    public String getObservacion() {
        return this.observacion;
    }

    @Generated
    public Long getCantidadUnidad() {
        return this.cantidadUnidad;
    }

    @Generated
    public Double getTemperatura() {
        return this.temperatura;
    }

    @Generated
    public Double getCantidadPendiente() {
        return this.cantidadPendiente;
    }

    @Generated
    public String getCodigoCum() {
        return this.codigoCum;
    }

    @Generated
    public String getCodigoAtc() {
        return this.codigoAtc;
    }

    @Generated
    public Short getCantidadMuestreo() {
        return this.cantidadMuestreo;
    }

    @Generated
    public Entrada getEntrada() {
        return this.entrada;
    }

    public EntradaDetalle(Entrada entrada) {
        this.entrada = entrada;
    }

    public Double getValorTotal() {
        return Double.valueOf(this.cantidad.doubleValue() * this.valorUnitario.doubleValue());
    }

    public Double getValorImpuesto() {
        Double valor = new Double(0.0d);
        if (this.poncentajeImpuesto.doubleValue() != 0.0d) {
            valor = Double.valueOf((this.valorUnitario.doubleValue() * this.poncentajeImpuesto.doubleValue()) / 100.0d);
        }
        return valor;
    }

    public Double getValorUnitarioFlete() {
        if (this.entrada == null || getPorcentajeProrrateo() == null || getCantidad() == null) {
            return Double.valueOf(0.0d);
        }
        Double valorFlete = this.entrada.getValorFlete();
        if (valorFlete == null || valorFlete.doubleValue() == 0.0d) {
            return Double.valueOf(0.0d);
        }
        return Double.valueOf((getPorcentajeProrrateo().doubleValue() * valorFlete.doubleValue()) / getCantidad().doubleValue());
    }

    public Double getValorUnitarioDescuento() {
        if (this.entrada == null || getPorcentajeProrrateo() == null || getCantidad() == null) {
            return Double.valueOf(0.0d);
        }
        Double valorDescuento = this.entrada.getValorDescuento();
        if (valorDescuento == null || valorDescuento.doubleValue() == 0.0d) {
            return Double.valueOf(0.0d);
        }
        return Double.valueOf((getPorcentajeProrrateo().doubleValue() * valorDescuento.doubleValue()) / getCantidad().doubleValue());
    }

    private Double getPorcentajeProrrateo() {
        if (this.entrada == null || this.entrada.getValorTotalCosto() == null || this.entrada.getValorTotalCosto().doubleValue() == 0.0d) {
            return Double.valueOf(0.0d);
        }
        Double valorTotal = getValorTotal();
        return Double.valueOf((valorTotal == null || valorTotal.doubleValue() <= 0.0d) ? 0.0d : valorTotal.doubleValue() / this.entrada.getValorTotalCosto().doubleValue());
    }

    public void setAdicionarCantidad(Double cantidad) {
        if (cantidad != null && cantidad.doubleValue() > 0.0d) {
            this.cantidad = Double.valueOf(this.cantidad == null ? cantidad.doubleValue() : this.cantidad.doubleValue() + cantidad.doubleValue());
        }
    }
}
