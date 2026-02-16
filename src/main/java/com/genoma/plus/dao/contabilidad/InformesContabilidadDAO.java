package com.genoma.plus.dao.contabilidad;

import com.genoma.plus.dto.contabilidad.ConsultarCCobroDTO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/contabilidad/InformesContabilidadDAO.class */
public interface InformesContabilidadDAO {
    List<ConsultarCCobroDTO> list(int i, String str);

    List<Object[]> listCuentasxPagarContaCart(String str, String str2, String str3, int i);

    List<Object[]> listCuentasxPagarContaCart_Ampliado(String str, String str2, String str3, int i);

    List<Object[]> listCuentasxPagarContaCartConsolidado(String str, String str2, String str3, int i);

    List<Object[]> listCuentasxPagarContaCartConsolidado_Ampliado(String str, String str2, String str3, int i);

    void mEjecutarSql(String str, String str2, String str3, String str4);

    List<Object[]> listTercerosInfome2276();

    void eliminarTablaInformes2276();

    List<GCGenericoDTO> listTdeFormatosDian();

    List<Object[]> datosFormato1005(String str, String str2);
}
