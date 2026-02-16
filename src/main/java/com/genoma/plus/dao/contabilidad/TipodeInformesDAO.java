package com.genoma.plus.dao.contabilidad;

import com.genoma.plus.dto.contabilidad.TipoDeInformeDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/contabilidad/TipodeInformesDAO.class */
public interface TipodeInformesDAO {
    List<TipoDeInformeDTO> listaTInformes();

    String mCreate(TipoDeInformeDTO tipoDeInformeDTO);

    String mUpdate(TipoDeInformeDTO tipoDeInformeDTO);
}
