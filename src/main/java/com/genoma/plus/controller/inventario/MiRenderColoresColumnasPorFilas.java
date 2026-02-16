package com.genoma.plus.controller.inventario;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/inventario/MiRenderColoresColumnasPorFilas.class */
public class MiRenderColoresColumnasPorFilas extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel columna = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (column == 4) {
            if (!value.equals("")) {
                Color color = new Color(Integer.parseInt(value.toString()));
                setOpaque(true);
                columna.setBackground(color);
                columna.setForeground(color);
            }
        } else {
            columna.setBackground(Color.white);
            columna.setForeground(Color.BLACK);
        }
        return this;
    }
}
