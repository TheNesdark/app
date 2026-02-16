package com.genoma.plus.controller.contabilidad;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.genoma.plus.dto.facturaelectronica.FacturaElectronicaDTO;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/contabilidad/FacturaElectronicaWrapper.class */
public class FacturaElectronicaWrapper {

    @JsonProperty("Invoice")
    FacturaElectronicaDTO invoice;

    public FacturaElectronicaDTO getInvoice() {
        return this.invoice;
    }

    public void setInvoice(FacturaElectronicaDTO invoice) {
        this.invoice = invoice;
    }
}
