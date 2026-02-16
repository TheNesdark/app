package com.genoma.plus.dao.contabilidad;

import com.genoma.plus.dto.contabilidad.PucTipoDeInformeDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/contabilidad/PucTipoDeInformesDAO.class */
public interface PucTipoDeInformesDAO {
    List<Object[]> listaPucTdeInforme();

    String mCreate(PucTipoDeInformeDTO pucTipoDeInformeDTO);

    String mUpdate(PucTipoDeInformeDTO pucTipoDeInformeDTO);

    List<Object[]> listaTipoInformes();

    List<Object[]> listaTipoInformesFiltrado(Integer num);
}
