package Citas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

/* JADX INFO: loaded from: GenomaP.jar:Citas/Nomenclatura.class */
public class Nomenclatura extends JDialog {
    private Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
    private JButton btnAceptar;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JPanel jPanel1;
    private JTextField jTextField1;
    private JTextField jTextField2;

    public Nomenclatura() {
        initComponents();
        Dimension ventana = getSize();
        setLocation((this.pantalla.width - ventana.width) / 2, (this.pantalla.height - ventana.height) / 2);
    }

    private void initComponents() {
        this.btnAceptar = new JButton();
        this.jPanel1 = new JPanel();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.jButton3 = new JButton();
        this.jTextField1 = new JTextField();
        this.jTextField2 = new JTextField();
        setTitle("Nomenclatura Utilizada en Gráficos");
        setName("Nomenclatura");
        this.btnAceptar.setFont(new Font("Arial", 1, 12));
        this.btnAceptar.setForeground(new Color(0, 0, 153));
        this.btnAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnAceptar.setText("Aceptar");
        this.btnAceptar.addActionListener(new ActionListener() { // from class: Citas.Nomenclatura.1
            public void actionPerformed(ActionEvent evt) {
                Nomenclatura.this.btnAceptarActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setForeground(new Color(0, 0, 153));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cita.png")));
        this.jButton1.setText("Programación general de cita");
        this.jButton1.setHorizontalAlignment(2);
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setForeground(new Color(0, 0, 153));
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/CitaEspecial.png")));
        this.jButton2.setText("Programación especial de citas");
        this.jButton2.setHorizontalAlignment(2);
        this.jButton3.setFont(new Font("Arial", 1, 12));
        this.jButton3.setForeground(new Color(0, 0, 153));
        this.jButton3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Citas29x27.png")));
        this.jButton3.setText("Programación de cita con vacaciones o tiempo libre");
        this.jButton3.setHorizontalAlignment(2);
        this.jTextField1.setBackground(new Color(255, 255, 204));
        this.jTextField1.setFont(new Font("Arial", 1, 12));
        this.jTextField1.setForeground(new Color(0, 0, 102));
        this.jTextField1.setText("Campo de cita de color amarillo es Usuario trabajador");
        this.jTextField2.setBackground(new Color(204, 255, 204));
        this.jTextField2.setFont(new Font("Arial", 1, 12));
        this.jTextField2.setForeground(new Color(0, 0, 102));
        this.jTextField2.setText("Campo reservado para las consultas de primer vez   ( las primeras 2 horas)");
        this.jTextField2.addActionListener(new ActionListener() { // from class: Citas.Nomenclatura.2
            public void actionPerformed(ActionEvent evt) {
                Nomenclatura.this.jTextField2ActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButton1, -1, 608, 32767).addComponent(this.jButton2, -1, 608, 32767).addComponent(this.jButton3, -1, 608, 32767).addComponent(this.jTextField1, -1, 608, 32767).addComponent(this.jTextField2, -1, 608, 32767)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.jButton1).addGap(18, 18, 18).addComponent(this.jButton2).addGap(18, 18, 18).addComponent(this.jButton3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextField1, -2, 28, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextField2, -2, 28, -2).addContainerGap(19, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2).addComponent(this.btnAceptar, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.jPanel1, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.btnAceptar).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAceptarActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jTextField2ActionPerformed(ActionEvent evt) {
    }
}
