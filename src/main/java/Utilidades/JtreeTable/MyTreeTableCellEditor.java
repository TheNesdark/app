package Utilidades.JtreeTable;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.TableCellEditor;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/JtreeTable/MyTreeTableCellEditor.class */
public class MyTreeTableCellEditor extends AbstractCellEditor implements TableCellEditor {
    private JTree tree;
    private JTable table;

    public MyTreeTableCellEditor(JTree tree, JTable table) {
        this.tree = tree;
        this.table = table;
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int r, int c) {
        return this.tree;
    }

    public boolean isCellEditable(EventObject e) {
        if (e instanceof MouseEvent) {
            MouseEvent me = (MouseEvent) e;
            MouseEvent newME = new MouseEvent(this.tree, me.getID(), me.getWhen(), me.getModifiers(), me.getX() - this.table.getCellRect(0, 0, true).x, me.getY(), 2, me.isPopupTrigger());
            this.tree.dispatchEvent(newME);
            return false;
        }
        return false;
    }

    public Object getCellEditorValue() {
        return null;
    }
}
