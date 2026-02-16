package Utilidades;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/JTableX.class */
public class JTableX extends JTable {
    protected RowEditorModel rm;

    public JTableX() {
        this.rm = null;
    }

    public JTableX(TableModel tm) {
        super(tm);
        this.rm = null;
    }

    public JTableX(TableModel tm, TableColumnModel cm) {
        super(tm, cm);
        this.rm = null;
    }

    public JTableX(TableModel tm, TableColumnModel cm, ListSelectionModel sm) {
        super(tm, cm, sm);
        this.rm = null;
    }

    public JTableX(int rows, int cols) {
        super(rows, cols);
        this.rm = null;
    }

    public JTableX(Vector rowData, Vector columnNames) {
        super(rowData, columnNames);
        this.rm = null;
    }

    public JTableX(Object[][] rowData, Object[] colNames) {
        super(rowData, colNames);
        this.rm = null;
    }

    public JTableX(TableModel tm, RowEditorModel rm) {
        super(tm, (TableColumnModel) null, (ListSelectionModel) null);
        this.rm = rm;
    }

    public void setRowEditorModel(RowEditorModel rm) {
        this.rm = rm;
    }

    public RowEditorModel getRowEditorModel() {
        return this.rm;
    }

    public TableCellEditor getCellEditor(int row, int col) {
        TableCellEditor tmpEditor = null;
        if (this.rm != null) {
            tmpEditor = this.rm.getEditor(row);
        }
        if (tmpEditor != null) {
            return tmpEditor;
        }
        return super.getCellEditor(row, col);
    }
}
