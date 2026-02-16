package Utilidades;

import java.awt.Dimension;
import javax.swing.JComboBox;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/JChomboBox.class */
public class JChomboBox extends JComboBox {
    public JChomboBox(int num_items) {
        Dimension d = new Dimension(180, 60);
        setSize(d);
        setPreferredSize(d);
        for (int i = 0; i < num_items; i++) {
            addItem(Integer.valueOf(i));
        }
        setVisible(true);
    }
}
