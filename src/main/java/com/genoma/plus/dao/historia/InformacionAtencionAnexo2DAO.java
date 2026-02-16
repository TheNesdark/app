package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.AnexoDosDTO;
import java.util.List;
import java.util.Optional;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/InformacionAtencionAnexo2DAO.class */
public interface InformacionAtencionAnexo2DAO {
    List<Object[]> informacionAtencionAnexo2FiltradaIdIngreso(String str);

    List<Object[]> informacionAtencionAnexo2FiltradaIdIngresoAnexonuevo(String str);

    List<Object[]> informacionHistoriaAtencionAnexo2FiltradaIdIngreso(String str);

    Long crear(AnexoDosDTO anexoDosDTO);

    Long consultarConsecutivoFecha(String str);

    List<Object[]> informacionIngresoAnexo2Res2335(String str);

    Optional<List<Object[]>> obtenerInformacionIngresoAnexo2Res2335(Long l);
}
