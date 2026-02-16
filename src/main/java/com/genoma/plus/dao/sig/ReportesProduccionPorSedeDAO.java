package com.genoma.plus.dao.sig;

import com.genoma.plus.dto.sig.ReportesProduccionPorSedeDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sig/ReportesProduccionPorSedeDAO.class */
public interface ReportesProduccionPorSedeDAO {
    List<Object[]> listar(ReportesProduccionPorSedeDTO reportesProduccionPorSedeDTO);

    List<Object[]> listarPorIdEmpresa(ReportesProduccionPorSedeDTO reportesProduccionPorSedeDTO);

    List<Object[]> listarEmpresasPorFechas(ReportesProduccionPorSedeDTO reportesProduccionPorSedeDTO);

    List<Object[]> listarSedesPorFechas(ReportesProduccionPorSedeDTO reportesProduccionPorSedeDTO);

    List<Object[]> listarPorIdSede(ReportesProduccionPorSedeDTO reportesProduccionPorSedeDTO);

    List<Object[]> listarPorIdSedeyEmpresa(ReportesProduccionPorSedeDTO reportesProduccionPorSedeDTO);
}
