package com.genoma.plus.dao.salud_ocupacional;

import com.genoma.plus.dto.salud_ocupacional.ControlDeRemisionDTO;
import com.genoma.plus.dto.salud_ocupacional.ControlDeRemisionesDetalleCitaDTO;
import com.genoma.plus.dto.salud_ocupacional.TipoAtencionRemisionDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/salud_ocupacional/ControlRemisionesDAO.class */
public interface ControlRemisionesDAO {
    List<Object[]> listarTipoAtencionServicio();

    List<Object[]> cargarTiposdeAtencionRemision();

    void grabarListaTiposAtencion(List<TipoAtencionRemisionDTO> list);

    void create(int i, TipoAtencionRemisionDTO tipoAtencionRemisionDTO);

    String grabarControlREmision(ControlDeRemisionDTO controlDeRemisionDTO);

    void grabarControlRemisionDetalleCita(List<ControlDeRemisionesDetalleCitaDTO> list);

    void grabarControlRemisionDetalleCitaMineros(List<ControlDeRemisionesDetalleCitaDTO> list);

    void actualizarControlRemisionDetalleCitaMineros(List<ControlDeRemisionesDetalleCitaDTO> list, List<Integer> list2);

    void actualizarControlRemision(ControlDeRemisionDTO controlDeRemisionDTO, Integer num, Integer num2, Integer num3, Integer num4);
}
