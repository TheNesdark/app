package com.genoma.plus.dao.sgc;

import com.genoma.plus.dto.sgc.InformePacientesFacturadosConFinalidadDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sgc/InformePacientesFacturadosConFinalidadDAO.class */
public interface InformePacientesFacturadosConFinalidadDAO {
    List<Object[]> mInformePacientesFacturadosConFinalidadFecha(InformePacientesFacturadosConFinalidadDTO informePacientesFacturadosConFinalidadDTO);

    List<Object[]> mInformePacientesFacturadosConFinalidadConvenio(InformePacientesFacturadosConFinalidadDTO informePacientesFacturadosConFinalidadDTO);

    List<Object[]> mInformePacientesFacturadosConFinalidadTipoAtencion(InformePacientesFacturadosConFinalidadDTO informePacientesFacturadosConFinalidadDTO);

    List<Object[]> mInformePacientesFacturadosConFinalidadTodos(InformePacientesFacturadosConFinalidadDTO informePacientesFacturadosConFinalidadDTO);

    List<Object[]> mCargarComboConvenio(InformePacientesFacturadosConFinalidadDTO informePacientesFacturadosConFinalidadDTO);

    List<Object[]> mCargarComboTipoAtencion(InformePacientesFacturadosConFinalidadDTO informePacientesFacturadosConFinalidadDTO);
}
