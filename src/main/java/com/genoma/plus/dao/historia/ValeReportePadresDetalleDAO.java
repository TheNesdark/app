package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.ValeReportePadresDetalleDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/ValeReportePadresDetalleDAO.class */
public interface ValeReportePadresDetalleDAO {
    List<Object[]> listaReportePadres(int i, int i2, int i3);

    void create(ValeReportePadresDetalleDTO valeReportePadresDetalleDTO);

    void update(ValeReportePadresDetalleDTO valeReportePadresDetalleDTO);

    List<Object[]> listaDeReportesGuardados(int i);

    List<Integer> buscarItemsPorRango(int i);

    List<Integer> buscarItemsVestibularPorRango(int i);
}
