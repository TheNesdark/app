package com.genoma.plus.controller.tipoDocumentoEmpresa;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/tipoDocumentoEmpresa/TipoDocumentoEmpresaTablaRender.class */
public class TipoDocumentoEmpresaTablaRender extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        table.setBackground(Color.white);
        table.setForeground(Color.BLACK);
        if (table.getValueAt(row, 9).toString().equalsIgnoreCase("true")) {
            table.setForeground(Color.RED);
        }
        if (value instanceof JButton) {
            JButton btn = (JButton) value;
            return btn;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
