package Utilidades;

import java.awt.Component;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/TextAreaRenderer.class */
public class TextAreaRenderer extends JTextArea implements TableCellRenderer {
    private final DefaultTableCellRenderer adaptee = new DefaultTableCellRenderer();
    private final Map cellSizes = new HashMap();

    public TextAreaRenderer() {
        setLineWrap(true);
        setWrapStyleWord(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
        this.adaptee.getTableCellRendererComponent(table, obj, isSelected, hasFocus, row, column);
        setForeground(this.adaptee.getForeground());
        setBackground(this.adaptee.getBackground());
        setBorder(this.adaptee.getBorder());
        setFont(this.adaptee.getFont());
        setText(this.adaptee.getText());
        TableColumnModel columnModel = table.getColumnModel();
        setSize(columnModel.getColumn(column).getWidth(), 100000);
        addSize(table, row, column, (int) getPreferredSize().getHeight());
        int height_wanted = findTotalMaximumRowSize(table, row);
        if (height_wanted != table.getRowHeight(row)) {
            table.setRowHeight(row, height_wanted);
        }
        return this;
    }

    private void addSize(JTable table, int row, int column, int height) {
        Map rows = (Map) this.cellSizes.get(table);
        if (rows == null) {
            Map map = this.cellSizes;
            HashMap map2 = new HashMap();
            rows = map2;
            map.put(table, map2);
        }
        Map rowheights = (Map) rows.get(new Integer(row));
        if (rowheights == null) {
            Integer num = new Integer(row);
            HashMap map3 = new HashMap();
            rowheights = map3;
            rows.put(num, map3);
        }
        rowheights.put(new Integer(column), new Integer(height));
    }

    private int findTotalMaximumRowSize(JTable table, int row) {
        int maximum_height = 0;
        Enumeration columns = table.getColumnModel().getColumns();
        while (columns.hasMoreElements()) {
            TableColumn tc = (TableColumn) columns.nextElement();
            TableCellRenderer cellRenderer = tc.getCellRenderer();
            if (cellRenderer instanceof TextAreaRenderer) {
                TextAreaRenderer tar = (TextAreaRenderer) cellRenderer;
                maximum_height = Math.max(maximum_height, tar.findMaximumRowSize(table, row));
            }
        }
        return maximum_height;
    }

    private int findMaximumRowSize(JTable table, int row) {
        Map rowheights;
        Map rows = (Map) this.cellSizes.get(table);
        if (rows == null || (rowheights = (Map) rows.get(new Integer(row))) == null) {
            return 0;
        }
        int maximum_height = 0;
        for (Map.Entry entry : rowheights.entrySet()) {
            int cellHeight = ((Integer) entry.getValue()).intValue();
            maximum_height = Math.max(maximum_height, cellHeight);
        }
        return maximum_height;
    }
}
