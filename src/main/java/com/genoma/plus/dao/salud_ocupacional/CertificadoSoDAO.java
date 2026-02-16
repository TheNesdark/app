package com.genoma.plus.dao.salud_ocupacional;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.salud_ocupacional.CertificadoSoDTO;
import com.genoma.plus.dto.salud_ocupacional.ConceptoxCertificadoSoDTO;
import com.genoma.plus.dto.salud_ocupacional.TipoCertificadoSoDTO;
import com.genoma.plus.dto.salud_ocupacional.TipoConceptoSoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/salud_ocupacional/CertificadoSoDAO.class */
public interface CertificadoSoDAO {
    List<CertificadoSoDTO> listCertificado(String str);

    List<GCGenericoDTO> listaComboTipoCertificados();

    List<GCGenericoDTO> listaComboTipoConcepto(String str);

    String createRevisionExamen(CertificadoSoDTO certificadoSoDTO);

    List<TipoCertificadoSoDTO> listTipoCertificado();

    String createTipoCertificado(TipoCertificadoSoDTO tipoCertificadoSoDTO);

    String updateTipoCertificado(TipoCertificadoSoDTO tipoCertificadoSoDTO);

    List<ConceptoxCertificadoSoDTO> listConceptoxCertificado(String str);

    List<GCGenericoDTO> listaComboConceptoxCertificado();

    String createConceptoxCertificado(ConceptoxCertificadoSoDTO conceptoxCertificadoSoDTO);

    List<TipoConceptoSoDTO> listTipoConcepto();

    String createTipoConcepto(TipoConceptoSoDTO tipoConceptoSoDTO);

    String updateTipoConcepto(TipoConceptoSoDTO tipoConceptoSoDTO);
}
