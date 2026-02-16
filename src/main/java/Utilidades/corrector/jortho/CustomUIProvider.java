package Utilidades.corrector.jortho;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/CustomUIProvider.class */
public interface CustomUIProvider {
    JButton getButton(String str);

    JTextField getTextField();

    JLabel getLabel(String str);

    JList getList();
}
