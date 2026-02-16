package com.genoma.plus.dao.sgc;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.sgc.SGC_AnalisisAccionDTO;
import com.genoma.plus.dto.sgc.SGC_AnalisisCausaDTO;
import com.genoma.plus.dto.sgc.SGC_AnalisisIntegranteDTO;
import com.genoma.plus.dto.sgc.SGC_AnalisisPCausaDTO;
import com.genoma.plus.dto.sgc.SGC_Analisis_EventoAdversoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sgc/SC_EventoAdversoGestionDAO.class */
public interface SC_EventoAdversoGestionDAO {
    List<SGC_Analisis_EventoAdversoDTO> listAnalisis(String str);

    List<SGC_AnalisisCausaDTO> listCausa(String str);

    List<SGC_AnalisisPCausaDTO> listPCausa(String str);

    List<SGC_AnalisisIntegranteDTO> listIntegrante(String str);

    List<SGC_AnalisisAccionDTO> listAccion(String str);

    List<GCGenericoDTO> listComboCausa();

    List<GCGenericoDTO> listaTProceso(String str);

    List<Object[]> listComboUsuario(String str);

    List<GCGenericoDTO> listComboAccion();

    List<Object[]> listComboRespon(String str);

    String create_return_id(SGC_Analisis_EventoAdversoDTO sGC_Analisis_EventoAdversoDTO);

    String create_causa(SGC_AnalisisCausaDTO sGC_AnalisisCausaDTO);

    String mCreatePCausa(SGC_AnalisisPCausaDTO sGC_AnalisisPCausaDTO);

    String mCreateIntegrante(SGC_AnalisisIntegranteDTO sGC_AnalisisIntegranteDTO);

    String mCreateAccion(SGC_AnalisisAccionDTO sGC_AnalisisAccionDTO);

    String mDeleteGeneral(SGC_Analisis_EventoAdversoDTO sGC_Analisis_EventoAdversoDTO);
}
