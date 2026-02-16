package Utilidades.JtreeTable;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.TreeSelectionModel;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/JtreeTable/MyTreeTable.class */
public class MyTreeTable extends JTable {
    public MyTreeTableCellRenderer tree;

    public MyTreeTable(MyAbstractTreeTableModel treeTableModel) {
        this.tree = new MyTreeTableCellRenderer(this, treeTableModel);
        super.setModel(new MyTreeTableModelAdapter(treeTableModel, this.tree));
        TreeSelectionModel myTreeTableSelectionModel = new MyTreeTableSelectionModel();
        this.tree.setSelectionModel(myTreeTableSelectionModel);
        expandAll(this.tree);
        setSelectionModel(myTreeTableSelectionModel.getListSelectionModel());
        getColumnModel().getColumn(0).setPreferredWidth(350);
        getColumnModel().getColumn(1).setPreferredWidth(120);
        getColumnModel().getColumn(2).setPreferredWidth(60);
        getColumnModel().getColumn(3).setPreferredWidth(60);
        getColumnModel().getColumn(4).setPreferredWidth(60);
        setSelectionBackground(Color.WHITE);
        setSelectionForeground(Color.RED);
        setFont(new Font("Arial", 1, 12));
        setDefaultRenderer(MyTreeTableModel.class, this.tree);
        setDefaultEditor(MyTreeTableModel.class, new MyTreeTableCellEditor(this.tree, this));
        setShowGrid(true);
        setIntercellSpacing(new Dimension(0, 0));
    }

    public void expandAll(JTree tree) {
        for (int row = 0; row < tree.getRowCount(); row++) {
            tree.expandRow(row);
        }
    }
}
