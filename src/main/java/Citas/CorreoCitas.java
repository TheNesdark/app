package Citas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Citas/CorreoCitas.class */
public class CorreoCitas extends JFrame {
    private JButton jButton1;
    private JButton jButton2;
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox3;
    private JCheckBox jCheckBox4;
    private JCheckBox jCheckBox5;
    private JCheckBox jCheckBox6;
    private JCheckBox jCheckBox7;
    private JCheckBox jCheckBox8;
    private JFormattedTextField jFormattedTextField1;
    private JPanel jPanel1;

    public CorreoCitas() {
        initComponents();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jCheckBox1 = new JCheckBox();
        this.jCheckBox2 = new JCheckBox();
        this.jCheckBox3 = new JCheckBox();
        this.jCheckBox4 = new JCheckBox();
        this.jCheckBox5 = new JCheckBox();
        this.jCheckBox6 = new JCheckBox();
        this.jCheckBox7 = new JCheckBox();
        this.jCheckBox8 = new JCheckBox();
        this.jFormattedTextField1 = new JFormattedTextField();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        setDefaultCloseOperation(3);
        setName("CorreoCitas");
        getContentPane().setLayout(new AbsoluteLayout());
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Configuración", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jPanel1.setLayout(new AbsoluteLayout());
        this.jCheckBox1.setFont(new Font("Arial", 1, 12));
        this.jCheckBox1.setForeground(new Color(0, 0, 255));
        this.jCheckBox1.setText("Todos");
        this.jPanel1.add(this.jCheckBox1, new AbsoluteConstraints(150, 130, -1, -1));
        this.jCheckBox2.setFont(new Font("Arial", 1, 12));
        this.jCheckBox2.setForeground(new Color(0, 0, 255));
        this.jCheckBox2.setText("Lunes");
        this.jPanel1.add(this.jCheckBox2, new AbsoluteConstraints(20, 40, -1, -1));
        this.jCheckBox3.setFont(new Font("Arial", 1, 12));
        this.jCheckBox3.setForeground(new Color(0, 0, 255));
        this.jCheckBox3.setText("Martes");
        this.jPanel1.add(this.jCheckBox3, new AbsoluteConstraints(20, 70, -1, -1));
        this.jCheckBox4.setFont(new Font("Arial", 1, 12));
        this.jCheckBox4.setForeground(new Color(0, 0, 255));
        this.jCheckBox4.setText("Miercoles");
        this.jPanel1.add(this.jCheckBox4, new AbsoluteConstraints(20, 100, -1, -1));
        this.jCheckBox5.setFont(new Font("Arial", 1, 12));
        this.jCheckBox5.setForeground(new Color(0, 0, 255));
        this.jCheckBox5.setText("Jueves");
        this.jPanel1.add(this.jCheckBox5, new AbsoluteConstraints(20, 130, -1, -1));
        this.jCheckBox6.setFont(new Font("Arial", 1, 12));
        this.jCheckBox6.setForeground(new Color(0, 0, 255));
        this.jCheckBox6.setText("Viernes");
        this.jPanel1.add(this.jCheckBox6, new AbsoluteConstraints(150, 40, -1, -1));
        this.jCheckBox7.setFont(new Font("Arial", 1, 12));
        this.jCheckBox7.setForeground(new Color(0, 0, 255));
        this.jCheckBox7.setText("Sábado");
        this.jPanel1.add(this.jCheckBox7, new AbsoluteConstraints(150, 70, -1, -1));
        this.jCheckBox8.setFont(new Font("Arial", 1, 12));
        this.jCheckBox8.setForeground(new Color(0, 0, 255));
        this.jCheckBox8.setText("Domingo");
        this.jPanel1.add(this.jCheckBox8, new AbsoluteConstraints(150, 100, -1, -1));
        this.jFormattedTextField1.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jPanel1.add(this.jFormattedTextField1, new AbsoluteConstraints(260, 40, 190, 60));
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setText("jButton1");
        this.jPanel1.add(this.jButton1, new AbsoluteConstraints(363, 123, 90, 30));
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setText("jButton1");
        this.jPanel1.add(this.jButton2, new AbsoluteConstraints(260, 123, 90, 30));
        getContentPane().add(this.jPanel1, new AbsoluteConstraints(0, 0, 480, 190));
        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() { // from class: Citas.CorreoCitas.1
            @Override // java.lang.Runnable
            public void run() {
                new CorreoCitas().setVisible(true);
            }
        });
    }
}
