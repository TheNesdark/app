package Historia.aiepi;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.Hashtable;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

/* JADX INFO: compiled from: JPAiepiNinos.java */
/* JADX INFO: loaded from: GenomaP.jar:Historia/aiepi/EachRowEditor.class */
class EachRowEditor implements TableCellEditor {
    protected TableCellEditor editor;
    JTable table;
    protected Hashtable editors = new Hashtable();
    protected TableCellEditor defaultEditor = new DefaultCellEditor(new JTextField());

    public EachRowEditor(JTable table) {
        this.table = table;
    }

    public void setEditorAt(int row, TableCellEditor editor) {
        this.editors.put(new Integer(row), editor);
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return this.editor.getTableCellEditorComponent(table, value, isSelected, row, column);
    }

    public Object getCellEditorValue() {
        return this.editor.getCellEditorValue();
    }

    public boolean stopCellEditing() {
        return this.editor.stopCellEditing();
    }

    public void cancelCellEditing() {
        this.editor.cancelCellEditing();
    }

    public boolean isCellEditable(EventObject anEvent) {
        selectEditor((MouseEvent) anEvent);
        return this.editor.isCellEditable(anEvent);
    }

    public void addCellEditorListener(CellEditorListener l) {
        this.editor.addCellEditorListener(l);
    }

    public void removeCellEditorListener(CellEditorListener l) {
        this.editor.removeCellEditorListener(l);
    }

    public boolean shouldSelectCell(EventObject anEvent) {
        selectEditor((MouseEvent) anEvent);
        return this.editor.shouldSelectCell(anEvent);
    }

    protected void selectEditor(MouseEvent e) {
        int row;
        if (e == null) {
            row = this.table.getSelectionModel().getAnchorSelectionIndex();
        } else {
            row = this.table.rowAtPoint(e.getPoint());
        }
        this.editor = (TableCellEditor) this.editors.get(new Integer(row));
        if (this.editor == null) {
            this.editor = this.defaultEditor;
        }
    }
}
