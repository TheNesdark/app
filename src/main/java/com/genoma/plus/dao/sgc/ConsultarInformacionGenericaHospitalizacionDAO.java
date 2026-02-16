package com.genoma.plus.dao.sgc;

import com.genoma.plus.dto.sgc.ConsultarInformacionGenericaHospitalizacionDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sgc/ConsultarInformacionGenericaHospitalizacionDAO.class */
public interface ConsultarInformacionGenericaHospitalizacionDAO {
    List<Object[]> mTotalDiasHospitalizado(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacionGenericaHospitalizacionDTO);

    List<Object[]> mCargarComboTotalDiasHospitalizado(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacionGenericaHospitalizacionDTO);

    List<Object[]> mTotalDiasHospitalizadoFiltro(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacionGenericaHospitalizacionDTO);

    List<Object[]> mInformeDeCamas(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacionGenericaHospitalizacionDTO);

    List<Object[]> mPacientesIngresados(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacionGenericaHospitalizacionDTO);

    List<Object[]> mPacientesIngresadosFiltro(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacionGenericaHospitalizacionDTO);

    List<Object[]> mCargarComboPacientesIngresados(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacionGenericaHospitalizacionDTO);

    List<Object[]> mPacientesEgresados(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacionGenericaHospitalizacionDTO);

    List<Object[]> mPacientesEgresadosFiltro(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacionGenericaHospitalizacionDTO);

    List<Object[]> mCargarComboPacientesEgresados(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacionGenericaHospitalizacionDTO);

    List<Object[]> mCitasNoProgramadasConsultaExterna(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacionGenericaHospitalizacionDTO);

    List<Object[]> mCitasNoProgramadasConsultaExternaFiltro(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacionGenericaHospitalizacionDTO);

    List<Object[]> mCargarComboCitasNoProgramadasConsultaExterna(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacionGenericaHospitalizacionDTO);

    List<Object[]> mCitasProgramadas(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacionGenericaHospitalizacionDTO);

    List<Object[]> mCitasProgramadasFiltro(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacionGenericaHospitalizacionDTO);

    List<Object[]> mCargarComboCitasProgramadas(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacionGenericaHospitalizacionDTO);
}
