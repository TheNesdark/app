package com.genoma.plus.dao.sig;

import com.genoma.plus.dto.sig.GenericoComboDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sig/Resolucion1604_DAO.class */
public interface Resolucion1604_DAO {
    List<GenericoComboDTO> comboEmpresa(String str, String str2);

    List<Object[]> listadoDatosResolucion(String str, String str2, Boolean bool, String str3);
}
