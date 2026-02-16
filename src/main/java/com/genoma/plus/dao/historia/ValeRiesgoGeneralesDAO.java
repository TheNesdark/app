package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.ValeRiesgoGeneralesDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/ValeRiesgoGeneralesDAO.class */
public interface ValeRiesgoGeneralesDAO {
    List<Object[]> listariesgoGenerales(int i);

    void create(ValeRiesgoGeneralesDTO valeRiesgoGeneralesDTO);

    void update(ValeRiesgoGeneralesDTO valeRiesgoGeneralesDTO);

    int verificarExistencia(String str);

    List<Object[]> obtenerRango(Integer num);
}
