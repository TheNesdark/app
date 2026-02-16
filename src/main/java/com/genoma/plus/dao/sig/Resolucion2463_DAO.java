package com.genoma.plus.dao.sig;

import com.genoma.plus.dto.sig.GenericoComboDTO;
import com.genoma.plus.dto.sig.JDVariablesResolucion2463DTO;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/sig/Resolucion2463_DAO.class */
public interface Resolucion2463_DAO {
    List<GenericoComboDTO> comboEmpresa();

    void eliminarTablaReso2463();

    void eliminarTablaTemporal();

    void mActualizarLotes(JPanel jPanel, JPanel jPanel2, String str, String str2);

    void mEjecutarSql(String str, String str2, JRadioButton jRadioButton);

    void mEjecutarSql_V35(String str, String str2);

    List<Object[]> mListadoCompleto(int i);

    List<Object[]> mListadoCompleto1();

    List<JDVariablesResolucion2463DTO> mCargarDatosSql2463(String str);

    void mEjecutarSqlJDialog2463(String str, String str2, JTable jTable, DefaultTableModel defaultTableModel, JRadioButton jRadioButton);
}
