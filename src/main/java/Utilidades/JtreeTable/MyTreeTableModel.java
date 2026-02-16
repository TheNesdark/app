package Utilidades.JtreeTable;

import javax.swing.tree.TreeModel;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/JtreeTable/MyTreeTableModel.class */
public interface MyTreeTableModel extends TreeModel {
    int getColumnCount();

    String getColumnName(int i);

    Class<?> getColumnClass(int i);

    Object getValueAt(Object obj, int i);

    boolean isCellEditable(Object obj, int i);

    void setValueAt(Object obj, Object obj2, int i);
}
