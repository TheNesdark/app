package com.genoma.plus.dao.laboratorio;

import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/laboratorio/RecepcionStikerDAO.class */
public interface RecepcionStikerDAO {
    List<Object[]> ListRecepcionStikers(String str, String str2, String str3, String str4, int i);

    List<Object[]> ListMunicipiosRecepcion(String str, String str2);

    List<Object[]> ListMunicipiosRecepcionMunicipio(String str);

    List<Object[]> ListRecepcionStikersBySedes(String str, String str2, String str3, String str4, int i);

    List<Object[]> ListRecepcionStikersBySedesAndArea(String str, String str2, String str3, String str4, int i, String str5);

    List<Object[]> ListRecepcionByRangos(Integer num, Integer num2);

    List<Object[]> ListRecepcionStikersCitologiaBySedes(String str, String str2, String str3, String str4, int i);

    List<Object[]> ListRecepcionByRangosCitologia(Integer num, Integer num2);
}
