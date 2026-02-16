package com.genoma.plus.dao.sig;

import com.genoma.plus.dto.sig.GenericoComboDTO;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sig/Resolucion4725_DAO.class */
public interface Resolucion4725_DAO {
    List<GenericoComboDTO> comboEmpresa();

    void eliminarTablaReso4725();

    void mActualizarLotes(JPanel jPanel, String str, String str2);

    void mEjecutarSql(String str, String str2, JRadioButton jRadioButton);

    List<Object[]> mListadoCompleto(int i);

    List<Object[]> mListadoCompleto1();
}
