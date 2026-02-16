package Utilidades.JtreeTable;

import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.tree.TreePath;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/JtreeTable/MyTreeTableModelAdapter.class */
public class MyTreeTableModelAdapter extends AbstractTableModel {
    JTree tree;
    MyAbstractTreeTableModel treeTableModel;

    public MyTreeTableModelAdapter(MyAbstractTreeTableModel treeTableModel, JTree tree) {
        this.tree = tree;
        this.treeTableModel = treeTableModel;
        tree.addTreeExpansionListener(new TreeExpansionListener() { // from class: Utilidades.JtreeTable.MyTreeTableModelAdapter.1
            public void treeExpanded(TreeExpansionEvent event) {
                MyTreeTableModelAdapter.this.fireTableDataChanged();
            }

            public void treeCollapsed(TreeExpansionEvent event) {
                MyTreeTableModelAdapter.this.fireTableDataChanged();
            }
        });
    }

    public int getColumnCount() {
        return this.treeTableModel.getColumnCount();
    }

    public String getColumnName(int column) {
        return this.treeTableModel.getColumnName(column);
    }

    public Class<?> getColumnClass(int column) {
        return this.treeTableModel.getColumnClass(column);
    }

    public int getRowCount() {
        return this.tree.getRowCount();
    }

    protected Object nodeForRow(int row) {
        TreePath treePath = this.tree.getPathForRow(row);
        return treePath.getLastPathComponent();
    }

    public Object getValueAt(int row, int column) {
        return this.treeTableModel.getValueAt(nodeForRow(row), column);
    }

    public boolean isCellEditable(int row, int column) {
        return this.treeTableModel.isCellEditable(nodeForRow(row), column);
    }

    public void setValueAt(Object value, int row, int column) {
        this.treeTableModel.setValueAt(value, nodeForRow(row), column);
    }
}
