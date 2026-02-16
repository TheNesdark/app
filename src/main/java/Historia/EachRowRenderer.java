package Historia;

import java.awt.Component;
import java.util.Hashtable;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/* JADX INFO: compiled from: JPSociodemografico.java */
/* JADX INFO: loaded from: GenomaP.jar:Historia/EachRowRenderer.class */
class EachRowRenderer implements TableCellRenderer {
    protected TableCellRenderer renderer;
    protected Hashtable renderers = new Hashtable();
    protected TableCellRenderer defaultRenderer = new DefaultTableCellRenderer();

    public void add(int row, TableCellRenderer renderer) {
        this.renderers.put(new Integer(row), renderer);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        this.renderer = (TableCellRenderer) this.renderers.get(new Integer(row));
        if (this.renderer == null) {
            this.renderer = this.defaultRenderer;
        }
        return this.renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
