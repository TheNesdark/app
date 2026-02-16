package com.genoma.plus.dao.facturacion;

import com.genoma.plus.dto.facturacion.EventoECastPacienteGastoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/facturacion/EventoECatPacienteGastoDAO.class */
public interface EventoECatPacienteGastoDAO {
    List<Object[]> listaEventoECatPacienteGasto(Long l, Long l2);

    List<Object[]> listaEventoECatPacienteGastoInternos(Long l, Long l2);

    String create(EventoECastPacienteGastoDTO eventoECastPacienteGastoDTO);

    String updtade(EventoECastPacienteGastoDTO eventoECastPacienteGastoDTO);

    List<Object[]> obtenerEventoCast(String str);

    String anulacion(Object[] objArr);
}
