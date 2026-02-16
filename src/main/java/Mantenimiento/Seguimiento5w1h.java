package Mantenimiento;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Mantenimiento/Seguimiento5w1h.class */
public class Seguimiento5w1h extends JInternalFrame {
    private JButton jButton1;
    private JComboBox jComboBox1;
    private JComboBox jComboBox2;
    private JComboBox jComboBox3;
    private JDateChooser jDateChooser1;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    private JTable jTable1;
    private JTable jTable2;
    private JTextArea jTextArea1;
    private JTextArea jTextArea2;
    private JTextArea jTextArea3;
    private JTextArea jTextArea4;

    public Seguimiento5w1h() {
        initComponents();
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v73, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.jTable1 = new JTable();
        this.jPanel2 = new JPanel();
        this.jPanel3 = new JPanel();
        this.jComboBox1 = new JComboBox();
        this.jComboBox2 = new JComboBox();
        this.jComboBox3 = new JComboBox();
        this.jDateChooser1 = new JDateChooser();
        this.jScrollPane2 = new JScrollPane();
        this.jTextArea1 = new JTextArea();
        this.jScrollPane3 = new JScrollPane();
        this.jTextArea3 = new JTextArea();
        this.jScrollPane4 = new JScrollPane();
        this.jTextArea2 = new JTextArea();
        this.jPanel4 = new JPanel();
        this.jScrollPane5 = new JScrollPane();
        this.jTextArea4 = new JTextArea();
        this.jPanel5 = new JPanel();
        this.jScrollPane6 = new JScrollPane();
        this.jTable2 = new JTable();
        this.jLabel1 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jButton1 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("SEGUIMIENTOS FICHA 5W1H");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        getContentPane().setLayout(new AbsoluteLayout());
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Ficha 5W1H", 0, 0, new Font("Arial", 1, 24), new Color(0, 102, 0)));
        this.jTable1.setFont(new Font("Arial", 1, 12));
        this.jTable1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        this.jTable1.setRowHeight(25);
        this.jTable1.setSelectionBackground(new Color(255, 255, 255));
        this.jTable1.setSelectionForeground(Color.red);
        this.jTable1.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.jTable1);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1, -1, 833, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 252, -2).addContainerGap(-1, 32767)));
        getContentPane().add(this.jPanel1, new AbsoluteConstraints(10, 0, -1, -1));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos de la Acción", 0, 0, new Font("Arial", 1, 18), new Color(255, 0, 0)));
        this.jPanel2.setEnabled(false);
        this.jPanel3.setBorder(new SoftBevelBorder(0, (Color) null, new Color(204, 204, 204), (Color) null, (Color) null));
        this.jComboBox1.setFont(new Font("Arial", 1, 12));
        this.jComboBox1.setModel(new DefaultComboBoxModel(new String[]{"Acción Correctiva", "Acción Preventiva", "Acción de mejora", "Tareas"}));
        this.jComboBox1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Acción", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jComboBox2.setFont(new Font("Arial", 1, 12));
        this.jComboBox2.setModel(new DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        this.jComboBox2.setBorder(BorderFactory.createTitledBorder((Border) null, "Quien Informa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jComboBox3.setFont(new Font("Arial", 1, 12));
        this.jComboBox3.setModel(new DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        this.jComboBox3.setBorder(BorderFactory.createTitledBorder((Border) null, "Donde", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jDateChooser1.setBorder(BorderFactory.createTitledBorder((Border) null, "CUANDO", 0, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.jDateChooser1.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jComboBox1, -2, 166, -2).addGap(18, 18, 18).addComponent(this.jComboBox2, -2, 172, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jComboBox3, -2, 179, -2).addGap(18, 18, 18).addComponent(this.jDateChooser1, -2, 220, -2).addContainerGap(28, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jComboBox1, -2, 49, -2).addComponent(this.jComboBox2, -2, 49, -2).addComponent(this.jComboBox3, -2, 49, -2))).addComponent(this.jDateChooser1, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.jTextArea1.setColumns(20);
        this.jTextArea1.setFont(new Font("Arial", 1, 12));
        this.jTextArea1.setRows(5);
        this.jTextArea1.setBorder(BorderFactory.createTitledBorder((Border) null, "QUE", 0, 0, new Font("Arial", 1, 14), new Color(0, 51, 255)));
        this.jScrollPane2.setViewportView(this.jTextArea1);
        this.jTextArea3.setColumns(20);
        this.jTextArea3.setFont(new Font("Arial", 1, 12));
        this.jTextArea3.setRows(5);
        this.jTextArea3.setBorder(BorderFactory.createTitledBorder((Border) null, "PARA QUE", 0, 0, new Font("Arial", 1, 14), new Color(0, 51, 255)));
        this.jScrollPane3.setViewportView(this.jTextArea3);
        this.jTextArea2.setColumns(20);
        this.jTextArea2.setFont(new Font("Arial", 1, 12));
        this.jTextArea2.setRows(5);
        this.jTextArea2.setBorder(BorderFactory.createTitledBorder((Border) null, "COMO", 0, 0, new Font("Arial", 1, 14), new Color(0, 51, 255)));
        this.jScrollPane4.setViewportView(this.jTextArea2);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -1, -1, 32767).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jScrollPane2, -2, 253, -2).addGap(18, 18, 18).addComponent(this.jScrollPane3, -1, 269, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane4, -2, 273, -2))).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane4, -2, 109, -2).addComponent(this.jScrollPane2, -2, 109, -2).addComponent(this.jScrollPane3, -2, 109, -2)).addContainerGap(12, 32767)));
        getContentPane().add(this.jPanel2, new AbsoluteConstraints(10, 310, 859, 240));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "Seguimiento", 0, 0, new Font("Arial", 1, 18), new Color(255, 0, 0)));
        this.jPanel4.setLayout(new AbsoluteLayout());
        this.jTextArea4.setColumns(20);
        this.jTextArea4.setFont(new Font("Arial", 1, 12));
        this.jTextArea4.setRows(5);
        this.jTextArea4.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Tahoma", 0, 18), new Color(0, 51, 255)));
        this.jScrollPane5.setViewportView(this.jTextArea4);
        this.jPanel4.add(this.jScrollPane5, new AbsoluteConstraints(20, 40, 446, 148));
        this.jPanel5.setBorder(BorderFactory.createTitledBorder("historial seguimiento"));
        this.jTable2.setFont(new Font("Arial", 1, 12));
        this.jTable2.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        this.jTable2.setRowHeight(25);
        this.jTable2.setSelectionBackground(new Color(255, 255, 255));
        this.jTable2.setSelectionForeground(new Color(255, 0, 0));
        this.jTable2.setSelectionMode(0);
        this.jScrollPane6.setViewportView(this.jTable2);
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane6, -1, 342, 32767).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane6, -1, 147, 32767));
        this.jPanel4.add(this.jPanel5, new AbsoluteConstraints(480, 20, -1, 170));
        getContentPane().add(this.jPanel4, new AbsoluteConstraints(10, 550, 860, 190));
        this.jLabel1.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setForeground(new Color(255, 0, 0));
        this.jLabel1.setText("...");
        getContentPane().add(this.jLabel1, new AbsoluteConstraints(400, 740, -1, 30));
        this.jLabel3.setFont(new Font("Arial", 1, 14));
        this.jLabel3.setForeground(new Color(255, 0, 0));
        this.jLabel3.setText("Fecha Ultimo Seguimiento");
        getContentPane().add(this.jLabel3, new AbsoluteConstraints(10, 740, -1, 30));
        this.jLabel4.setFont(new Font("Arial", 1, 14));
        this.jLabel4.setForeground(new Color(255, 0, 0));
        this.jLabel4.setText("...");
        getContentPane().add(this.jLabel4, new AbsoluteConstraints(200, 740, -1, 30));
        this.jLabel5.setFont(new Font("Arial", 1, 14));
        this.jLabel5.setForeground(new Color(255, 0, 0));
        this.jLabel5.setText("ESTADO");
        getContentPane().add(this.jLabel5, new AbsoluteConstraints(320, 740, -1, 30));
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setText("AGREGAR 1 SEGUIMIENTO MAS  ( 1 + )");
        this.jButton1.addActionListener(new ActionListener() { // from class: Mantenimiento.Seguimiento5w1h.1
            public void actionPerformed(ActionEvent evt) {
                Seguimiento5w1h.this.jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(this.jButton1, new AbsoluteConstraints(510, 750, 350, -1));
        getAccessibleContext().setAccessibleName("");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
    }
}
