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

/* JADX INFO: compiled from: JPAiepiAtencionMadres.java */
/* JADX INFO: loaded from: GenomaP.jar:Historia/aiepi/EachRowEditor2.class */
class EachRowEditor2 implements TableCellEditor {
    protected TableCellEditor editor2;
    JTable table;
    protected Hashtable editors2 = new Hashtable();
    protected TableCellEditor defaultEditor2 = new DefaultCellEditor(new JTextField());

    public EachRowEditor2(JTable table) {
        this.table = table;
    }

    public void setEditorAt(int row, TableCellEditor editor) {
        this.editors2.put(new Integer(row), editor);
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return this.editor2.getTableCellEditorComponent(table, value, isSelected, row, column);
    }

    public Object getCellEditorValue() {
        return this.editor2.getCellEditorValue();
    }

    public boolean stopCellEditing() {
        return this.editor2.stopCellEditing();
    }

    public void cancelCellEditing() {
        this.editor2.cancelCellEditing();
    }

    public boolean isCellEditable(EventObject anEvent) {
        selectEditor((MouseEvent) anEvent);
        return this.editor2.isCellEditable(anEvent);
    }

    public void addCellEditorListener(CellEditorListener l) {
        this.editor2.addCellEditorListener(l);
    }

    public void removeCellEditorListener(CellEditorListener l) {
        this.editor2.removeCellEditorListener(l);
    }

    public boolean shouldSelectCell(EventObject anEvent) {
        selectEditor((MouseEvent) anEvent);
        return this.editor2.shouldSelectCell(anEvent);
    }

    protected void selectEditor(MouseEvent e) {
        int row;
        if (e == null) {
            row = this.table.getSelectionModel().getAnchorSelectionIndex();
        } else {
            row = this.table.rowAtPoint(e.getPoint());
        }
        this.editor2 = (TableCellEditor) this.editors2.get(new Integer(row));
        if (this.editor2 == null) {
            this.editor2 = this.defaultEditor2;
        }
    }
}
