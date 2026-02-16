package com.genoma.plus.dao.parametrizacion;

import com.genoma.plus.dto.parametrizacion.ConsultorioDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/parametrizacion/ConsultorioDAO.class */
public interface ConsultorioDAO {
    List<Object[]> listConsultorios();

    List<Object[]> listClaseConsultorios();

    void addConsultorio(ConsultorioDTO consultorioDTO);

    void updateConsultorio(ConsultorioDTO consultorioDTO);
}
