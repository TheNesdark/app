package com.genoma.plus.jpa.service.impl;

import com.genoma.plus.jpa.entity.NominaNovedadesEncabezado;
import com.genoma.plus.jpa.repository.EncabezadoNovedadesNominaRepository;
import com.genoma.plus.jpa.service.EncabezadoNovedadesNominaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/jpa/service/impl/EncabezadoNovedadesNominaServiceImpl.class */
@Service("encabezadoNovedadesNominaService")
public class EncabezadoNovedadesNominaServiceImpl implements EncabezadoNovedadesNominaService {

    @Autowired
    private EncabezadoNovedadesNominaRepository encabezadoNovedadesNominaRepository;

    @Override // com.genoma.plus.jpa.service.EncabezadoNovedadesNominaService
    public NominaNovedadesEncabezado guardar(NominaNovedadesEncabezado nominaNovedadesEncabezado) {
        return (NominaNovedadesEncabezado) this.encabezadoNovedadesNominaRepository.save(nominaNovedadesEncabezado);
    }
}
