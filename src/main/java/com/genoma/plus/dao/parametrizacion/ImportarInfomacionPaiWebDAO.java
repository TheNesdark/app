package com.genoma.plus.dao.parametrizacion;

import com.genoma.plus.dto.parametrizacion.ImportPaiWebDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/parametrizacion/ImportarInfomacionPaiWebDAO.class */
public interface ImportarInfomacionPaiWebDAO {
    void InsertPaiWeb(ImportPaiWebDTO importPaiWebDTO);

    void VerificarExistenciaUsuarios();

    void ejecutarSql();

    List<Object[]> ListadoPacientesInexistentes();
}
