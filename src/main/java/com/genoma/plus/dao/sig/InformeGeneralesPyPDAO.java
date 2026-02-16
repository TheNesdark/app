package com.genoma.plus.dao.sig;

import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sig/InformeGeneralesPyPDAO.class */
public interface InformeGeneralesPyPDAO {
    void mEjecutarSql(String str, String str2, String str3, String str4);

    List<GCGenericoDTO> listaempresa();

    List<Object[]> ListadoInformaTipo1();

    List<Object[]> ListadoInformaTipo2();

    List<Object[]> ListadoInformaTipo3();

    void mLimpiarTabla(String str);
}
