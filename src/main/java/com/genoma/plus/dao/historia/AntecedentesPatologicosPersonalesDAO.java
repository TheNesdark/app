package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.AntecedentesPatologicosPersonalesDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/AntecedentesPatologicosPersonalesDAO.class */
public interface AntecedentesPatologicosPersonalesDAO {
    List<AntecedentesPatologicosPersonalesDTO> listaAntecedentesAtencion(String str, String str2, String str3, String str4, String str5, String str6);

    String mCreate(AntecedentesPatologicosPersonalesDTO antecedentesPatologicosPersonalesDTO);

    String mUpdate(AntecedentesPatologicosPersonalesDTO antecedentesPatologicosPersonalesDTO);
}
