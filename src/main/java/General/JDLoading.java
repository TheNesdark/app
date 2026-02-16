package General;

import java.awt.Font;
import java.awt.Frame;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;

/* JADX INFO: loaded from: GenomaP.jar:General/JDLoading.class */
public class JDLoading extends JDialog {
    private JButton jButton1;
    private JLabel jLabel2;

    public JDLoading(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void initComponents() {
        this.jLabel2 = new JLabel();
        this.jButton1 = new JButton();
        setDefaultCloseOperation(2);
        this.jLabel2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Loadin_Pequeno.gif")));
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cancelar30x30.png")));
        this.jButton1.setText("Cancelar");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(43, 43, 43).addComponent(this.jLabel2)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jButton1, -2, 160, -2))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1).addGap(12, 12, 12)));
        pack();
    }
}
