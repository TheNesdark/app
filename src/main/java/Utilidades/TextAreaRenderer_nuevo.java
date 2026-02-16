package Utilidades;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/TextAreaRenderer_nuevo.class */
public class TextAreaRenderer_nuevo extends JTextArea implements TableCellRenderer {
    public TextAreaRenderer_nuevo() {
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value != null ? value.toString() : "");
        Integer estado = obtenerEntero(table, row, 14);
        setBackground(getColorPorEstado(estado));
        if (isSelected) {
            setBackground(table.getSelectionBackground());
            setForeground(table.getSelectionForeground());
        } else {
            setForeground(Color.BLACK);
        }
        return this;
    }

    private Integer obtenerEntero(JTable table, int row, int column) {
        try {
            Object valor = table.getValueAt(row, column);
            if (valor instanceof Number) {
                return Integer.valueOf(((Number) valor).intValue());
            }
            return Integer.valueOf(Integer.parseInt(valor.toString().trim()));
        } catch (Exception e) {
            return null;
        }
    }

    private Color getColorPorEstado(Integer estado) {
        if (estado == null) {
            return Color.WHITE;
        }
        switch (estado.intValue()) {
            case 1:
                return new Color(153, 255, 102);
            case 2:
                return new Color(255, 255, 204);
            default:
                return Color.WHITE;
        }
    }
}
