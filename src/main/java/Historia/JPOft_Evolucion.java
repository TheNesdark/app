package Historia;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPOft_Evolucion.class */
public class JPOft_Evolucion extends JPanel {
    private ButtonGroup Hiperemia;
    private ButtonGroup Inferior;
    public JTextField JLBalance;
    public JTextField JLCC;
    public JTextField JLCilindro;
    public JTextField JLEje;
    public JTextField JLEsfera;
    public JTextField JLK1;
    public JTextField JLK2;
    public JTextField JLLA;
    public JTextField JLLIO;
    public JTextField JLMEO;
    public JTextField JLSC;
    private ButtonGroup Nasal;
    private ButtonGroup Secrecion;
    private ButtonGroup Superior;
    private ButtonGroup Temporal;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;

    public JPOft_Evolucion(String xNombre) {
        initComponents();
        setBorder(BorderFactory.createTitledBorder((Border) null, xNombre, 0, 0, new Font("Arial", 1, 14), Color.red));
    }

    private void initComponents() {
        this.Superior = new ButtonGroup();
        this.Inferior = new ButtonGroup();
        this.Hiperemia = new ButtonGroup();
        this.Nasal = new ButtonGroup();
        this.Temporal = new ButtonGroup();
        this.Secrecion = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.JLSC = new JTextField();
        this.JLCC = new JTextField();
        this.JLEsfera = new JTextField();
        this.JLCilindro = new JTextField();
        this.JLEje = new JTextField();
        this.jLabel2 = new JLabel();
        this.JLK1 = new JTextField();
        this.JLK2 = new JTextField();
        this.jLabel3 = new JLabel();
        this.JLLIO = new JTextField();
        this.JLLA = new JTextField();
        this.JLBalance = new JTextField();
        this.JLMEO = new JTextField();
        setPreferredSize(new Dimension(387, 630));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("AGUDEZA VISUAL:");
        this.JLSC.setFont(new Font("Arial", 1, 11));
        this.JLSC.setBorder(BorderFactory.createTitledBorder((Border) null, "S/C", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLCC.setFont(new Font("Arial", 1, 11));
        this.JLCC.setBorder(BorderFactory.createTitledBorder((Border) null, "C/C", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLEsfera.setFont(new Font("Arial", 1, 11));
        this.JLEsfera.setBorder(BorderFactory.createTitledBorder((Border) null, "Esfera", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLCilindro.setFont(new Font("Arial", 1, 11));
        this.JLCilindro.setBorder(BorderFactory.createTitledBorder((Border) null, "Cilindro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLEje.setFont(new Font("Arial", 1, 11));
        this.JLEje.setBorder(BorderFactory.createTitledBorder((Border) null, "Eje", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText("KETOMETRIA:");
        this.JLK1.setFont(new Font("Arial", 1, 11));
        this.JLK1.setBorder(BorderFactory.createTitledBorder((Border) null, "K1", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLK2.setFont(new Font("Arial", 1, 11));
        this.JLK2.setBorder(BorderFactory.createTitledBorder((Border) null, "K2", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLK2.addActionListener(new ActionListener() { // from class: Historia.JPOft_Evolucion.1
            public void actionPerformed(ActionEvent evt) {
                JPOft_Evolucion.this.JLK2ActionPerformed(evt);
            }
        });
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setText("BIOMETRÍA:");
        this.JLLIO.setFont(new Font("Arial", 1, 11));
        this.JLLIO.setBorder(BorderFactory.createTitledBorder((Border) null, "LIO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLLA.setFont(new Font("Arial", 1, 11));
        this.JLLA.setBorder(BorderFactory.createTitledBorder((Border) null, "LA", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBalance.setFont(new Font("Arial", 1, 11));
        this.JLBalance.setBorder(BorderFactory.createTitledBorder((Border) null, "Balance", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLMEO.setFont(new Font("Arial", 1, 11));
        this.JLMEO.setBorder(BorderFactory.createTitledBorder((Border) null, "MEO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(6, 6, 6).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JLEsfera, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLCilindro, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLEje, -2, 81, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLSC, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLCC, -2, 60, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JLBalance, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLMEO)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.jLabel3)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JLLIO, -2, 60, -2).addGap(6, 6, 6).addComponent(this.JLLA, -2, 60, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JLK1, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLK2, -2, 60, -2))))).addContainerGap(47, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(1, 1, 1).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.JLSC, -2, 35, -2).addComponent(this.JLCC, -2, 35, -2)).addGap(1, 1, 1).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLEsfera, -2, 35, -2).addComponent(this.JLCilindro, -2, 35, -2).addComponent(this.JLEje, -2, 35, -2)).addGap(1, 1, 1).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLK1, -2, 35, -2).addComponent(this.JLK2, -2, 35, -2).addComponent(this.jLabel2)).addGap(1, 1, 1).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.JLLIO, -2, 35, -2).addComponent(this.JLLA, -2, 35, -2)).addGap(1, 1, 1).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLMEO, -2, 35, -2).addComponent(this.JLBalance, -2, 0, 32767)).addGap(1, 1, 1)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(3, 3, 3)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jPanel1, -2, -1, -2).addGap(3, 3, 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JLK2ActionPerformed(ActionEvent evt) {
    }
}
