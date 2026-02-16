package com.genoma.plus.dao.historia;

import com.genoma.plus.dto.historia.ListaDeChequeoDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/ListaDeChequeoDAO.class */
public interface ListaDeChequeoDAO {
    List<Object[]> obtenerListaDeChequeo(int i, String str, String str2);

    List<Object[]> obtenerListaDeChequeoH(int i, String str, String str2, String str3);

    void crearLista(ListaDeChequeoDTO listaDeChequeoDTO);

    void updateLista(ListaDeChequeoDTO listaDeChequeoDTO);
}
