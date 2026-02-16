package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.Atencion_Informacion_n10DTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/Atencion_Informacion_N10DAO.class */
public interface Atencion_Informacion_N10DAO {
    void mCreate(Atencion_Informacion_n10DTO atencion_Informacion_n10DTO);

    void mUpdate(Atencion_Informacion_n10DTO atencion_Informacion_n10DTO);

    List<Object[]> listAtencionFiltradaNombreItems(Long l, String str, String str2, Integer num, String str3, String str4, String str5);

    List<Object[]> listHistoricoAtenciones(Long l, String str, Long l2);
}
