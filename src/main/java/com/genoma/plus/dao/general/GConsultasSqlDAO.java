package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.LogUsuariosDuplicadosDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/GConsultasSqlDAO.class */
public interface GConsultasSqlDAO {
    List<Object[]> ListaDeConsultas(int i);

    String ejecuarSql1(String str, String str2);

    String ejecutarSql2(String str, String str2, String str3);

    String InsertarDuplicados(LogUsuariosDuplicadosDTO logUsuariosDuplicadosDTO);

    String devolverEdadDosFechas(String str, String str2);
}
