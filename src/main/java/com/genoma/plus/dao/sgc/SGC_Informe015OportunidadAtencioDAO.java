package com.genoma.plus.dao.sgc;

import com.genoma.plus.dto.sgc.SGC_Informe015OportunidadAtencionDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sgc/SGC_Informe015OportunidadAtencioDAO.class */
public interface SGC_Informe015OportunidadAtencioDAO {
    List<Object[]> list(SGC_Informe015OportunidadAtencionDTO sGC_Informe015OportunidadAtencionDTO);

    List<Object[]> listarporEmpresa(SGC_Informe015OportunidadAtencionDTO sGC_Informe015OportunidadAtencionDTO);

    List<Object[]> listarComboEmpresas();
}
