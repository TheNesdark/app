package Laboratorio;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/Render.class */
public class Render extends DefaultTableCellRenderer {
    public int xDato;
    public int xValorColmna;

    public Render(int xDato, int xValorColmna) {
        this.xDato = 0;
        this.xValorColmna = 0;
        this.xDato = xDato;
        this.xValorColmna = xValorColmna;
    }

    public void fillColor(JTable t, JLabel l, boolean isSelected) {
        if (isSelected) {
            l.setBackground(t.getSelectionBackground());
            l.setForeground(t.getSelectionForeground());
        } else {
            l.setBackground(t.getBackground());
            l.setForeground(t.getForeground());
        }
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof JLabel) {
            JLabel label = (JLabel) value;
            if (null == Integer.valueOf(table.getValueAt(row, this.xValorColmna).toString())) {
                label.setIcon((Icon) null);
            } else {
                switch (Integer.valueOf(table.getValueAt(row, this.xValorColmna).toString()).intValue()) {
                    case 1:
                        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Atencion Discapasitaods.png")));
                        break;
                    case 2:
                        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Atencion Embarazada.png")));
                        break;
                    case 3:
                        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Atencion Ancianos.png")));
                        break;
                    case 4:
                        label.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AtpNiños.png")));
                        break;
                    default:
                        label.setIcon((Icon) null);
                        break;
                }
            }
            label.setOpaque(true);
            fillColor(table, label, isSelected);
            return label;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
