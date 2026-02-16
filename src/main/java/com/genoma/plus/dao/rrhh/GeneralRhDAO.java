package com.genoma.plus.dao.rrhh;

import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/rrhh/GeneralRhDAO.class */
public interface GeneralRhDAO {
    List<Object[]> mListadoUsuario(String str);

    List<Object[]> listadoUnidadFuncionalConceptoNomina();

    List<Object[]> listadoConceptoNominaUnidadFuncional(String str);
}
