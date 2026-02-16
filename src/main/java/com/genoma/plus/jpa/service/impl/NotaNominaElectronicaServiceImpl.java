package com.genoma.plus.jpa.service.impl;

import com.genoma.plus.jpa.entity.INumeroSecuenciaXML;
import com.genoma.plus.jpa.entity.NotasNominaElectronica;
import com.genoma.plus.jpa.repository.NotaNominaRepository;
import com.genoma.plus.jpa.service.NotaNominaElectronicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/jpa/service/impl/NotaNominaElectronicaServiceImpl.class */
@Service
public class NotaNominaElectronicaServiceImpl implements NotaNominaElectronicaService {

    @Autowired
    private NotaNominaRepository nominaRepository;

    @Override // com.genoma.plus.jpa.service.NotaNominaElectronicaService
    public NotasNominaElectronica guardar(NotasNominaElectronica nominaNominaElectronica) {
        return (NotasNominaElectronica) this.nominaRepository.save(nominaNominaElectronica);
    }

    @Override // com.genoma.plus.jpa.service.NotaNominaElectronicaService
    public INumeroSecuenciaXML numeroSecuenciaXMLNotas(Integer numero) {
        System.out.println("numero " + numero);
        return this.nominaRepository.obtenerNota(numero);
    }

    @Override // com.genoma.plus.jpa.service.NotaNominaElectronicaService
    public Long buscarNota(Long id) {
        return ((NotasNominaElectronica) this.nominaRepository.findById(id).get()).getConsecutivo();
    }
}
