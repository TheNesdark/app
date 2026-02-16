package Utilidades;

import java.awt.Component;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/JChomboRenderer.class */
public class JChomboRenderer extends JLabel implements ListCellRenderer {
    private ImageIcon[] items;

    public JChomboRenderer(ImageIcon[] items) {
        setOpaque(true);
        this.items = items;
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        int selectedIndex = ((Integer) value).intValue();
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setIcon(this.items[selectedIndex]);
        File f = new File(this.items[selectedIndex].toString());
        setText(f.getName());
        return this;
    }
}
