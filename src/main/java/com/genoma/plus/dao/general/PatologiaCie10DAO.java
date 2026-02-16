package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.PatologiaCie10DTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/PatologiaCie10DAO.class */
public interface PatologiaCie10DAO {
    List<PatologiaCie10DTO> listPatologiaFiltrada(String str, String str2);

    PatologiaCie10DTO patologiaFiltrada(String str, Integer num);

    Integer patologiaFiltradaEdad(String str, String str2, String str3);

    List<Object[]> listPatologiaFichaSivigila(String str);

    List<Object[]> listReporteFichaSivigila(String str);

    List<Object[]> informacionGeneracionFichaSivigila(String str, String str2);
}
