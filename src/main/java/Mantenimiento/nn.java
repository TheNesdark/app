package Mantenimiento;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/* JADX INFO: loaded from: GenomaP.jar:Mantenimiento/nn.class */
public class nn extends JInternalFrame {
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel19;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JTabbedPane jTabbedPane2;

    public nn() {
        initComponents();
    }

    private void initComponents() {
        this.jTabbedPane2 = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jPanel3 = new JPanel();
        this.jLabel2 = new JLabel();
        this.jPanel5 = new JPanel();
        this.jLabel4 = new JLabel();
        this.jPanel6 = new JPanel();
        this.jLabel5 = new JLabel();
        this.jPanel7 = new JPanel();
        this.jLabel6 = new JLabel();
        this.jPanel8 = new JPanel();
        this.jLabel7 = new JLabel();
        this.jPanel19 = new JPanel();
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.jTabbedPane2.setForeground(new Color(0, 102, 0));
        this.jTabbedPane2.setFont(new Font("Arial", 0, 10));
        this.jPanel2.setLayout((LayoutManager) null);
        this.jLabel1.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setForeground(new Color(51, 51, 255));
        this.jLabel1.setText("Ingresar tipo Manuales");
        this.jPanel2.add(this.jLabel1);
        this.jLabel1.setBounds(320, 0, 162, 17);
        this.jTabbedPane2.addTab("MANUALES", this.jPanel2);
        this.jLabel2.setFont(new Font("Arial", 1, 14));
        this.jLabel2.setForeground(new Color(51, 51, 255));
        this.jLabel2.setText("Ingresar Registros Tecnicos");
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2).addGap(511, 511, 511)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel2).addContainerGap(75, 32767)));
        this.jTabbedPane2.addTab("REG. TECNICOS", this.jPanel3);
        this.jPanel5.setLayout((LayoutManager) null);
        this.jLabel4.setFont(new Font("Arial", 1, 14));
        this.jLabel4.setForeground(new Color(51, 51, 255));
        this.jLabel4.setText("Ingresar Repuestos");
        this.jPanel5.add(this.jLabel4);
        this.jLabel4.setBounds(320, 0, 139, 17);
        this.jTabbedPane2.addTab("REPUESTOS", this.jPanel5);
        this.jLabel5.setFont(new Font("Arial", 1, 14));
        this.jLabel5.setForeground(new Color(51, 51, 255));
        this.jLabel5.setText("Ingresar Tipo Procedimientos");
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup().addContainerGap(485, 32767).addComponent(this.jLabel5).addGap(53, 53, 53)));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jLabel5).addContainerGap(75, 32767)));
        this.jTabbedPane2.addTab("TIPO PROCEDIMIENTOS", this.jPanel6);
        this.jPanel7.setLayout((LayoutManager) null);
        this.jLabel6.setFont(new Font("Arial", 1, 14));
        this.jLabel6.setForeground(new Color(51, 51, 255));
        this.jLabel6.setText("Ingresar Tipo Normalidad");
        this.jPanel7.add(this.jLabel6);
        this.jLabel6.setBounds(310, 0, 176, 17);
        this.jTabbedPane2.addTab("TIPO NORMALIDADES", this.jPanel7);
        this.jPanel8.setLayout((LayoutManager) null);
        this.jLabel7.setFont(new Font("Arial", 1, 14));
        this.jLabel7.setForeground(new Color(51, 51, 255));
        this.jLabel7.setText("Ingresar Tipo Calibracion");
        this.jPanel8.add(this.jLabel7);
        this.jLabel7.setBounds(300, 0, 176, 17);
        this.jTabbedPane2.addTab("TIPO CALIBRACION", this.jPanel8);
        GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
        this.jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 745, 32767));
        jPanel19Layout.setVerticalGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 92, 32767));
        this.jTabbedPane2.addTab("FRECUENCIA PROC.", this.jPanel19);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jTabbedPane2, -2, -1, -2)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.jTabbedPane2, -2, -1, -2)));
        pack();
    }
}
