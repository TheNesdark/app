package com.genoma.plus.dao.presupuesto;

import com.genoma.plus.dto.presupuesto.RubrosContraloriaDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/presupuesto/RubrosContraloriaDAO.class */
public interface RubrosContraloriaDAO {
    List<Object[]> listaRubroContraloria();

    String mCreate(RubrosContraloriaDTO rubrosContraloriaDTO);

    String mUpdate(RubrosContraloriaDTO rubrosContraloriaDTO);

    boolean ValidarExistencia(String str);

    List<Object[]> filtroRubrosContraloria(String str);
}
