package com.genoma.plus.jpa.service.impl;

import com.genoma.plus.jpa.entity.NominaNovedadesDetalle;
import com.genoma.plus.jpa.repository.DetalleNovedadesNominaRepository;
import com.genoma.plus.jpa.service.DetalleNovedadesNominaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/jpa/service/impl/DetalleNovedadNominaServiceImpl.class */
@Transactional
@Service
public class DetalleNovedadNominaServiceImpl implements DetalleNovedadesNominaService {

    @Autowired
    private DetalleNovedadesNominaRepository detalleNovedadesNominaRepository;

    @Override // com.genoma.plus.jpa.service.DetalleNovedadesNominaService
    public List<NominaNovedadesDetalle> guardar(List<NominaNovedadesDetalle> nominaNovedadesDetalle) {
        return this.detalleNovedadesNominaRepository.saveAll(nominaNovedadesDetalle);
    }
}
