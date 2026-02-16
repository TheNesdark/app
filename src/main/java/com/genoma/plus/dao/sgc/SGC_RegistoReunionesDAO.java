package com.genoma.plus.dao.sgc;

import com.genoma.plus.dto.sgc.SGC_RegistroReuniones;
import com.genoma.plus.dto.sgc.SGC_RegistroReunionesIntegrantesDTO;
import com.genoma.plus.dto.sgc.SGC_RegistroReunionesObjetivosDTO;
import com.genoma.plus.dto.sgc.SGC_RegistroReunionesRecursosDTO;
import com.genoma.plus.dto.sgc.SGC_TipoRecurso_Reunion;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sgc/SGC_RegistoReunionesDAO.class */
public interface SGC_RegistoReunionesDAO {
    List<SGC_TipoRecurso_Reunion> listTipoRecursos();

    List<SGC_RegistroReuniones> listReuniones();

    List<SGC_RegistroReunionesObjetivosDTO> listObjetivos(String str);

    List<SGC_RegistroReunionesIntegrantesDTO> listIntegrantes(String str);

    List<SGC_RegistroReunionesRecursosDTO> listRecursos(String str);

    List<Object[]> listTipoRecursos_Utilizados(int i, String str, Long l);

    String create_return_id(SGC_RegistroReuniones sGC_RegistroReuniones);

    String create_objetivo(SGC_RegistroReunionesObjetivosDTO sGC_RegistroReunionesObjetivosDTO);

    String create_integrante(SGC_RegistroReunionesIntegrantesDTO sGC_RegistroReunionesIntegrantesDTO);

    String create_recurso(SGC_RegistroReunionesRecursosDTO sGC_RegistroReunionesRecursosDTO);
}
