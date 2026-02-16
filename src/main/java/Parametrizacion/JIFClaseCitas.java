package Parametrizacion;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

/* JADX INFO: loaded from: GenomaP.jar:Parametrizacion/JIFClaseCitas.class */
public class JIFClaseCitas extends JInternalFrame {
    public JIFClaseCitas() {
        initComponents();
    }

    private void initComponents() {
        setTitle("CLASE CITAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 394, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 278, 32767));
        pack();
    }
}
