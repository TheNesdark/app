package com.genoma.plus.dao.inventario;

import com.genoma.plus.dto.sig.GenericoComboDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/inventario/InventarioGeneralDAO.class */
public interface InventarioGeneralDAO {
    List<Object[]> List(String str, String str2, String str3, int i);

    List<GenericoComboDTO> cargarCombo();

    List<Object[]> cargarViaAdministreacionPosIdSuministro(String str);

    List<Object[]> listadoSuministroSoluciones();

    List<Object[]> listadoUnidadMedidadFiltradaUci();

    List<Object[]> listadoFormaAplicacion();
}
