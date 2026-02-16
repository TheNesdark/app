package com.genoma.plus.dao.sgc;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.sgc.SGC_ActasAccionConclusionDTO;
import com.genoma.plus.dto.sgc.SGC_ActasAsistentesDTO;
import com.genoma.plus.dto.sgc.SGC_ActasDTO;
import com.genoma.plus.dto.sgc.SGC_Ficha5w1hDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sgc/SGC_ActasDAO.class */
public interface SGC_ActasDAO {
    List<SGC_ActasDTO> listActas(String str, String str2, String str3, String str4);

    List<SGC_ActasAccionConclusionDTO> listConclusion(String str);

    List<SGC_ActasAsistentesDTO> listAsistentes(String str);

    List<GCGenericoDTO> lisTipoProceso();

    List<SGC_ActasAsistentesDTO> listComboUsuario(String str);

    List<GCGenericoDTO> listComboAccion();

    List<GCGenericoDTO> listTipoReunion();

    List<GCGenericoDTO> listOrigen(int i);

    String create_return_id(SGC_ActasDTO sGC_ActasDTO);

    String create_return_idFicha(SGC_Ficha5w1hDTO sGC_Ficha5w1hDTO);

    String mCreateActaAsistentes(SGC_ActasAsistentesDTO sGC_ActasAsistentesDTO);

    String mCreateActaConcluson(SGC_ActasAccionConclusionDTO sGC_ActasAccionConclusionDTO);

    String mUpdate(SGC_ActasDTO sGC_ActasDTO);
}
