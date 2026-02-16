package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.GeneralDTO;
import com.genoma.plus.dto.general.UsuarioSistemaDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/UsuarioSistemaDAO.class */
public interface UsuarioSistemaDAO {
    void desactivarUsuarioSistema(String str);

    List<UsuarioSistemaDTO> usuarioSistema(String str);

    List<GeneralDTO> usuarioSistemaSede(String str);

    List<Object[]> usuarioSistemaModulo(String str);
}
