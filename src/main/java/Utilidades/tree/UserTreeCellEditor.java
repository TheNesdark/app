package Utilidades.tree;

import java.awt.Component;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/tree/UserTreeCellEditor.class */
public class UserTreeCellEditor extends DefaultTreeCellEditor {
    private HierarchicalItem item;

    public UserTreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer) {
        super(tree, renderer);
    }

    public Object getCellEditorValue() {
        Object returnValue;
        Object value = super.getCellEditorValue();
        if (this.item == null) {
            returnValue = value;
        } else {
            this.item.setData(value);
            returnValue = this.item;
        }
        return returnValue;
    }

    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
        if (value instanceof DefaultMutableTreeNode) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
            Object userObject = node.getUserObject();
            if (userObject instanceof HierarchicalItem) {
                this.item = (HierarchicalItem) node.getUserObject();
            }
        }
        return super.getTreeCellEditorComponent(tree, value, isSelected, expanded, leaf, row);
    }
}
