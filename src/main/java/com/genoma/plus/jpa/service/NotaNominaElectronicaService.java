package com.genoma.plus.jpa.service;

import com.genoma.plus.jpa.entity.INumeroSecuenciaXML;
import com.genoma.plus.jpa.entity.NotasNominaElectronica;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/jpa/service/NotaNominaElectronicaService.class */
public interface NotaNominaElectronicaService {
    NotasNominaElectronica guardar(NotasNominaElectronica notasNominaElectronica);

    INumeroSecuenciaXML numeroSecuenciaXMLNotas(Integer num);

    Long buscarNota(Long l);
}
