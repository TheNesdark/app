package Inventarios;

import java.util.ArrayList;
import java.util.List;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/Entrada.class */
public class Entrada {
    private Double valorFlete;
    private Double valorDescuento;
    private Double valorTotalCosto;
    private Double valorTotalIva;
    private List<EntradaDetalle> detalleEntrada;

    @Generated
    public void setValorFlete(Double valorFlete) {
        this.valorFlete = valorFlete;
    }

    @Generated
    public void setValorDescuento(Double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    @Generated
    public void setValorTotalCosto(Double valorTotalCosto) {
        this.valorTotalCosto = valorTotalCosto;
    }

    @Generated
    public void setValorTotalIva(Double valorTotalIva) {
        this.valorTotalIva = valorTotalIva;
    }

    @Generated
    public void setDetalleEntrada(List<EntradaDetalle> detalleEntrada) {
        this.detalleEntrada = detalleEntrada;
    }

    @Generated
    public Entrada(Double valorFlete, Double valorDescuento, Double valorTotalCosto, Double valorTotalIva, List<EntradaDetalle> detalleEntrada) {
        this.valorFlete = valorFlete;
        this.valorDescuento = valorDescuento;
        this.valorTotalCosto = valorTotalCosto;
        this.valorTotalIva = valorTotalIva;
        this.detalleEntrada = detalleEntrada;
    }

    @Generated
    public Double getValorFlete() {
        return this.valorFlete;
    }

    @Generated
    public Double getValorDescuento() {
        return this.valorDescuento;
    }

    @Generated
    public Double getValorTotalCosto() {
        return this.valorTotalCosto;
    }

    @Generated
    public Double getValorTotalIva() {
        return this.valorTotalIva;
    }

    @Generated
    public List<EntradaDetalle> getDetalleEntrada() {
        return this.detalleEntrada;
    }

    public Entrada() {
        this.detalleEntrada = new ArrayList();
    }

    public void setAddDetalleEntrada(EntradaDetalle detalle) {
        boolean existe = false;
        if (this.detalleEntrada.isEmpty()) {
            this.detalleEntrada.add(detalle);
        } else {
            for (int i = 0; i < this.detalleEntrada.size(); i++) {
                if (this.detalleEntrada.get(i).getIdSuministro().equals(detalle.getIdSuministro()) && this.detalleEntrada.get(i).getLote().equals(detalle.getLote())) {
                    this.detalleEntrada.get(i).setAdicionarCantidad(detalle.getCantidad());
                    existe = true;
                }
            }
            if (!existe) {
                this.detalleEntrada.add(detalle);
            }
        }
        getSubTotalEntrada();
    }

    public void getSubTotalEntrada() {
        Double valorCosto = new Double(0.0d);
        Double valorIva = new Double(0.0d);
        for (EntradaDetalle entradaDetalle : this.detalleEntrada) {
            valorCosto = Double.valueOf(valorCosto.doubleValue() + entradaDetalle.getValorTotal().doubleValue());
            valorIva = Double.valueOf(valorIva.doubleValue() + (entradaDetalle.getValorImpuesto().doubleValue() * entradaDetalle.getCantidad().doubleValue()));
        }
        setValorTotalCosto(valorCosto);
        setValorTotalIva(valorIva);
    }

    public Double getTotalFactura() {
        Double valorTotalCosto = Double.valueOf(getValorTotalCosto() != null ? getValorTotalCosto().doubleValue() : 0.0d);
        Double valorTotalIva = Double.valueOf(getValorTotalIva() != null ? getValorTotalIva().doubleValue() : 0.0d);
        Double valorFlete = Double.valueOf(getValorFlete() != null ? getValorFlete().doubleValue() : 0.0d);
        Double valorDescuento = Double.valueOf(getValorDescuento() != null ? getValorDescuento().doubleValue() : 0.0d);
        return Double.valueOf(((valorTotalCosto.doubleValue() + valorTotalIva.doubleValue()) + valorFlete.doubleValue()) - valorDescuento.doubleValue());
    }

    public void removeItemDetalle(int pos) {
        this.detalleEntrada.remove(pos);
    }
}
