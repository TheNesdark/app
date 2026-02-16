package Utilidades.JtreeTable;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.TreeModel;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/JtreeTable/MyTreeTableCellRenderer.class */
public class MyTreeTableCellRenderer extends JTree implements TableCellRenderer {
    protected int visibleRow;
    private MyTreeTable treeTable;

    public MyTreeTableCellRenderer(MyTreeTable treeTable, TreeModel model) {
        super(model);
        this.treeTable = treeTable;
        setRowHeight(getRowHeight());
    }

    public void setRowHeight(int rowHeight) {
        if (rowHeight > 0) {
            super.setRowHeight(rowHeight);
            if (this.treeTable != null && this.treeTable.getRowHeight() != rowHeight) {
                this.treeTable.setRowHeight(getRowHeight());
            }
        }
    }

    public void setBounds(int x, int y, int w, int h) {
        super.setBounds(x, 0, w, this.treeTable.getHeight());
    }

    public void paint(Graphics g) {
        g.translate(0, (-this.visibleRow) * getRowHeight());
        super.paint(g);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setBackground(table.getSelectionBackground());
        } else {
            setBackground(table.getBackground());
        }
        this.visibleRow = row;
        return this;
    }
}
