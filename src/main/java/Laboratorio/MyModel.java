package Laboratorio;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: compiled from: PruebaTabla.java */
/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/MyModel.class */
class MyModel extends DefaultTableModel {
    Object[][] row = {new Object[]{new JLabel("Row 1 Col 1"), "Row 1 Col 2", "Row 1 Col3"}, new Object[]{new JLabel("Row 2 Col 1"), "Row 2 Col 2", "Row 2 Col3"}, new Object[]{new JLabel("Row 3 Col 1"), "Row 3 Col 2", "Row 3 Col3"}, new Object[]{new JLabel("Row 4 Col 1"), "Row 4 Col 2", "Row 4 Col3"}};
    Object[] col = {"Column 1", "Column 2", "Column 3"};

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public MyModel() {
        for (Object c : this.col) {
            addColumn(c);
        }
        for (Object[] r : this.row) {
            addRow(r);
        }
    }

    public Class getColumnClass(int columnIndex) {
        return columnIndex == 0 ? getValueAt(0, columnIndex).getClass() : super.getColumnClass(columnIndex);
    }
}
