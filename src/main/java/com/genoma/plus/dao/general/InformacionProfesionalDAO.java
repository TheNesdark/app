package com.genoma.plus.dao.general;

import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/InformacionProfesionalDAO.class */
public interface InformacionProfesionalDAO {
    List<Object[]> listadoEspecialidadConProfesional();

    List<Object[]> listadoProfesionalFiltradoPorEspecialidad(String str);
}
