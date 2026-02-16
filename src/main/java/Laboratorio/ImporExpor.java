package Laboratorio;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/ImporExpor.class */
public class ImporExpor extends JInternalFrame {
    private JPanel jPanel1;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;

    public ImporExpor() {
        initComponents();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jRadioButton1 = new JRadioButton();
        this.jRadioButton2 = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("IMPORTAR / EXPORTAR DATOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("ImporExpor");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Que desea hacer?", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jRadioButton1.setFont(new Font("Arial", 1, 12));
        this.jRadioButton1.setForeground(new Color(0, 0, 255));
        this.jRadioButton1.setSelected(true);
        this.jRadioButton1.setText("Importar");
        this.jRadioButton2.setFont(new Font("Arial", 1, 12));
        this.jRadioButton2.setForeground(new Color(0, 0, 255));
        this.jRadioButton2.setText("Exportar");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jRadioButton1).addGap(31, 31, 31).addComponent(this.jRadioButton2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRadioButton1).addComponent(this.jRadioButton2)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(195, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(217, 32767)));
        pack();
    }
}
