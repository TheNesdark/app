package Utilidades;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/JIFPlantilla.class */
public class JIFPlantilla extends JInternalFrame {
    public JIFPlantilla() {
        initComponents();
    }

    private void initComponents() {
        setClosable(true);
        setIconifiable(true);
        setFont(new Font("Arial", 1, 13));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 877, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 516, 32767));
        pack();
    }
}
