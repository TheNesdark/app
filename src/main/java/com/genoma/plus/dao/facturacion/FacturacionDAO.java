package com.genoma.plus.dao.facturacion;

import com.genoma.plus.dto.facturacion.GenericoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/facturacion/FacturacionDAO.class */
public interface FacturacionDAO {
    List<GenericoDTO> listProcedimientoTipo(Long l);

    List<GenericoDTO> listProcedimientoRelacionado(Long l);

    List<GenericoDTO> listProcedimiento(String str);

    List<GenericoDTO> listOtroProcedimiento(String str);

    List<GenericoDTO> listSuministro(String str);

    List<GenericoDTO> listMaterialAnexo1(String str);

    List<Object[]> listSalidaInventario(Long l);

    List<Object[]> listSalidaInventarioCTipoMovimiento(Long l);

    void addProcedimientoRelacionado(String str, String str2, Integer num);

    void updateProcedimientoRelacionado(String str, String str2, Integer num);
}
