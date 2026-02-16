package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.ExamenFisicoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/ExamenFisicoDAO.class */
public interface ExamenFisicoDAO {
    List<Object[]> listConfDetalleExamenFisico(String str, String str2);

    Long mCrear(ExamenFisicoDTO examenFisicoDTO);

    void mActualizar(ExamenFisicoDTO examenFisicoDTO);

    List<ExamenFisicoDTO> listExamenFisico(String str);

    List<Object[]> listInformacionTriage(String str);

    Integer consultarEdadUsuario(String str);
}
