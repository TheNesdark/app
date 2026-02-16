package com.genoma.plus.dao.historia;

import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/InformacionVariaUrgenciasHospitalizacionDAO.class */
public interface InformacionVariaUrgenciasHospitalizacionDAO {
    List<Object[]> listadoServiciosEspecialidad(Long l, Integer num);

    List<Object[]> listadoServiciosEnfermeria();

    List<Object[]> listadoServiciosEspecialidadFiltroCirugia(Long l);
}
