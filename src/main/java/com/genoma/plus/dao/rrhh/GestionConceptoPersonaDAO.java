package com.genoma.plus.dao.rrhh;

import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/rrhh/GestionConceptoPersonaDAO.class */
public interface GestionConceptoPersonaDAO {
    List<Object[]> listadoConceptosPersona(String str, int i, String str2);

    void iniciarValoresFijos(String str, String str2);

    void iniciarValoresHoras(String str, String str2);

    void actualizarValoresConceptoPersona(String str, String str2, Boolean bool, Double d, Double d2);

    String buscarConceptoNomina(String str);
}
