package com.genoma.plus.controller.contabilidad;

import com.genoma.plus.dto.facturaelectronica.FacturaElectronicaDTO;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/contabilidad/BillEventRequester.class */
public class BillEventRequester {
    FacturaElectronicaDTO invoice;
    PersonRequester responsiblePerson;

    public FacturaElectronicaDTO getInvoice() {
        return this.invoice;
    }

    public void setInvoice(FacturaElectronicaDTO invoice) {
        this.invoice = invoice;
    }

    public PersonRequester getResponsiblePerson() {
        return this.responsiblePerson;
    }

    public void setResponsiblePerson(PersonRequester responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public String toString() {
        return "BillEventRequester{invoice=" + this.invoice + ", responsiblePerson=" + this.responsiblePerson + '}';
    }
}
