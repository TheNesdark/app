package Utilidades;

import java.awt.Component;
import java.util.Hashtable;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/JCBRenderImagen.class */
public class JCBRenderImagen extends JLabel implements ListCellRenderer {
    Hashtable<Object, ImageIcon> icono;

    public JCBRenderImagen(String[] nombre, ImageIcon[] img) {
        this.icono = null;
        this.icono = new Hashtable<>();
        for (int i = 0; i < nombre.length; i++) {
            this.icono.put(nombre[i], img[i]);
        }
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value != null && this.icono.get(value) != null) {
            setIcon((Icon) this.icono.get(value));
        } else {
            setIcon(null);
        }
        return this;
    }
}
