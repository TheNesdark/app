package Utilidades;

import java.util.Hashtable;
import javax.swing.table.TableCellEditor;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/RowEditorModel.class */
public class RowEditorModel {
    private Hashtable data = new Hashtable();

    public void addEditorForRow(int row, TableCellEditor e) {
        this.data.put(new Integer(row), e);
    }

    public void removeEditorForRow(int row) {
        this.data.remove(new Integer(row));
    }

    public TableCellEditor getEditor(int row) {
        return (TableCellEditor) this.data.get(new Integer(row));
    }
}
