package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.historia.AntecedentesGinecobstetricosDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/AntecedentesGinecobstetricosDAO.class */
public interface AntecedentesGinecobstetricosDAO {
    String mCreate(AntecedentesGinecobstetricosDTO antecedentesGinecobstetricosDTO);

    List<AntecedentesGinecobstetricosDTO> listAnteGinecoobstetrico(int i);

    String mUpdate(AntecedentesGinecobstetricosDTO antecedentesGinecobstetricosDTO);

    List<GCGenericoDTO> listMetodosPlanificar();

    boolean validarAtencion(int i, int i2);
}
