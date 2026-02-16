package Utilidades;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.table.TableCellEditor;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/TextAreaEditor_nuevo.class */
public class TextAreaEditor_nuevo extends AbstractCellEditor implements TableCellEditor {
    private final JScrollPane scrollPane;
    private Color currentBackground = Color.WHITE;
    private final JTextArea textArea = new JTextArea();

    public TextAreaEditor_nuevo() {
        this.textArea.setLineWrap(true);
        this.textArea.setWrapStyleWord(true);
        this.textArea.setOpaque(true);
        this.scrollPane = new JScrollPane(this.textArea);
        this.scrollPane.setBorder((Border) null);
        this.textArea.addFocusListener(new FocusListener() { // from class: Utilidades.TextAreaEditor_nuevo.1
            public void focusGained(FocusEvent e) {
                TextAreaEditor_nuevo.this.textArea.setBackground(TextAreaEditor_nuevo.this.currentBackground);
            }

            public void focusLost(FocusEvent e) {
                TextAreaEditor_nuevo.this.textArea.setBackground(TextAreaEditor_nuevo.this.currentBackground);
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.textArea.setText(value != null ? value.toString() : "");
        Integer estado = obtenerEntero(table, row, 14);
        this.currentBackground = getColorPorEstado(estado);
        this.textArea.setBackground(this.currentBackground);
        return this.scrollPane;
    }

    public Object getCellEditorValue() {
        return this.textArea.getText();
    }

    private Integer obtenerEntero(JTable table, int row, int column) {
        try {
            Object valor = table.getValueAt(row, column);
            if (valor instanceof Number) {
                return Integer.valueOf(((Number) valor).intValue());
            }
            return Integer.valueOf(Integer.parseInt(valor.toString().trim()));
        } catch (NumberFormatException e) {
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
