package com.genoma.plus.dao.parametrizacion;

import com.genoma.plus.dto.parametrizacion.AuditorPorEmpresaDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/parametrizacion/AuditorPorEmpresaDAO.class */
public interface AuditorPorEmpresaDAO {
    List<Object[]> mCargarCombo();

    List<Object[]> mCargarTabla(AuditorPorEmpresaDTO auditorPorEmpresaDTO);

    String mValidarExiste(AuditorPorEmpresaDTO auditorPorEmpresaDTO);

    String mGrabar(AuditorPorEmpresaDTO auditorPorEmpresaDTO);

    String mUpdate(AuditorPorEmpresaDTO auditorPorEmpresaDTO);
}
