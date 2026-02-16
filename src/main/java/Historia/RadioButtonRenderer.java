package Historia;

import java.awt.Component;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/* JADX INFO: compiled from: JPAdultoMayor.java */
/* JADX INFO: loaded from: GenomaP.jar:Historia/RadioButtonRenderer.class */
class RadioButtonRenderer implements TableCellRenderer {
    public JRadioButton btn = new JRadioButton();

    RadioButtonRenderer() {
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value == null) {
            return null;
        }
        this.btn.setSelected(((Boolean) value).booleanValue());
        return this.btn;
    }
}
