package Historia;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPSo_VisiometriaDistancias.class */
public class JPSo_VisiometriaDistancias extends JPanel {
    private int xOptAO;
    private int xOptOD;
    private int xOptOI;
    public ArrayList<String> AO = new ArrayList<>();
    public ArrayList<String> OD = new ArrayList<>();
    public ArrayList<String> OI = new ArrayList<>();
    private JRadioButton AO1;
    private JRadioButton AO10;
    private JRadioButton AO2;
    private JRadioButton AO3;
    private JRadioButton AO4;
    private JRadioButton AO5;
    private JRadioButton AO6;
    private JRadioButton AO7;
    private JRadioButton AO8;
    private JRadioButton AO9;
    public JComboBox<String> JCBClaAO;
    public JComboBox<String> JCBClaOD;
    public JComboBox<String> JCBClaOI;
    public JLabel JLLineaAO;
    public JLabel JLLineaOD;
    public JLabel JLLineaOI;
    public JLabel JLNivelAO;
    public JLabel JLNivelOD;
    public JLabel JLNivelOI;
    public JLabel JLOptotipoAO;
    public JLabel JLOptotiposOD;
    public JLabel JLOptotiposOI;
    public JPanel JPAO;
    public JPanel JPOD;
    public JPanel JPOI;
    private JRadioButton OD1;
    private JRadioButton OD10;
    private JRadioButton OD2;
    private JRadioButton OD3;
    private JRadioButton OD4;
    private JRadioButton OD5;
    private JRadioButton OD6;
    private JRadioButton OD7;
    private JRadioButton OD8;
    private JRadioButton OD9;
    private JRadioButton OI1;
    private JRadioButton OI10;
    private JRadioButton OI2;
    private JRadioButton OI3;
    private JRadioButton OI4;
    private JRadioButton OI5;
    private JRadioButton OI6;
    private JRadioButton OI7;
    private JRadioButton OI8;
    private JRadioButton OI9;
    private ButtonGroup ambosOjos;
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox10;
    private JCheckBox jCheckBox100;
    private JCheckBox jCheckBox101;
    private JCheckBox jCheckBox102;
    private JCheckBox jCheckBox103;
    private JCheckBox jCheckBox104;
    private JCheckBox jCheckBox105;
    private JCheckBox jCheckBox106;
    private JCheckBox jCheckBox107;
    private JCheckBox jCheckBox108;
    private JCheckBox jCheckBox109;
    private JCheckBox jCheckBox11;
    private JCheckBox jCheckBox110;
    private JCheckBox jCheckBox111;
    private JCheckBox jCheckBox112;
    private JCheckBox jCheckBox113;
    private JCheckBox jCheckBox114;
    private JCheckBox jCheckBox115;
    private JCheckBox jCheckBox116;
    private JCheckBox jCheckBox117;
    private JCheckBox jCheckBox118;
    private JCheckBox jCheckBox119;
    private JCheckBox jCheckBox12;
    private JCheckBox jCheckBox120;
    private JCheckBox jCheckBox121;
    private JCheckBox jCheckBox122;
    private JCheckBox jCheckBox123;
    private JCheckBox jCheckBox124;
    private JCheckBox jCheckBox125;
    private JCheckBox jCheckBox126;
    private JCheckBox jCheckBox127;
    private JCheckBox jCheckBox128;
    private JCheckBox jCheckBox129;
    private JCheckBox jCheckBox13;
    private JCheckBox jCheckBox130;
    private JCheckBox jCheckBox131;
    private JCheckBox jCheckBox132;
    private JCheckBox jCheckBox133;
    private JCheckBox jCheckBox134;
    private JCheckBox jCheckBox135;
    private JCheckBox jCheckBox136;
    private JCheckBox jCheckBox137;
    private JCheckBox jCheckBox138;
    private JCheckBox jCheckBox139;
    private JCheckBox jCheckBox14;
    private JCheckBox jCheckBox140;
    private JCheckBox jCheckBox141;
    private JCheckBox jCheckBox142;
    private JCheckBox jCheckBox143;
    private JCheckBox jCheckBox144;
    private JCheckBox jCheckBox145;
    private JCheckBox jCheckBox146;
    private JCheckBox jCheckBox147;
    private JCheckBox jCheckBox148;
    private JCheckBox jCheckBox149;
    private JCheckBox jCheckBox15;
    private JCheckBox jCheckBox150;
    private JCheckBox jCheckBox151;
    private JCheckBox jCheckBox152;
    private JCheckBox jCheckBox153;
    private JCheckBox jCheckBox154;
    private JCheckBox jCheckBox155;
    private JCheckBox jCheckBox156;
    private JCheckBox jCheckBox157;
    private JCheckBox jCheckBox158;
    private JCheckBox jCheckBox159;
    private JCheckBox jCheckBox16;
    private JCheckBox jCheckBox160;
    private JCheckBox jCheckBox161;
    private JCheckBox jCheckBox162;
    private JCheckBox jCheckBox163;
    private JCheckBox jCheckBox164;
    private JCheckBox jCheckBox165;
    private JCheckBox jCheckBox166;
    private JCheckBox jCheckBox167;
    private JCheckBox jCheckBox168;
    private JCheckBox jCheckBox169;
    private JCheckBox jCheckBox17;
    private JCheckBox jCheckBox170;
    private JCheckBox jCheckBox171;
    private JCheckBox jCheckBox172;
    private JCheckBox jCheckBox173;
    private JCheckBox jCheckBox174;
    private JCheckBox jCheckBox175;
    private JCheckBox jCheckBox176;
    private JCheckBox jCheckBox177;
    private JCheckBox jCheckBox178;
    private JCheckBox jCheckBox179;
    private JCheckBox jCheckBox18;
    private JCheckBox jCheckBox180;
    private JCheckBox jCheckBox19;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox20;
    private JCheckBox jCheckBox21;
    private JCheckBox jCheckBox22;
    private JCheckBox jCheckBox23;
    private JCheckBox jCheckBox24;
    private JCheckBox jCheckBox25;
    private JCheckBox jCheckBox26;
    private JCheckBox jCheckBox27;
    private JCheckBox jCheckBox28;
    private JCheckBox jCheckBox29;
    private JCheckBox jCheckBox3;
    private JCheckBox jCheckBox30;
    private JCheckBox jCheckBox31;
    private JCheckBox jCheckBox32;
    private JCheckBox jCheckBox33;
    private JCheckBox jCheckBox34;
    private JCheckBox jCheckBox35;
    private JCheckBox jCheckBox36;
    private JCheckBox jCheckBox37;
    private JCheckBox jCheckBox38;
    private JCheckBox jCheckBox39;
    private JCheckBox jCheckBox4;
    private JCheckBox jCheckBox40;
    private JCheckBox jCheckBox41;
    private JCheckBox jCheckBox42;
    private JCheckBox jCheckBox43;
    private JCheckBox jCheckBox44;
    private JCheckBox jCheckBox45;
    private JCheckBox jCheckBox46;
    private JCheckBox jCheckBox47;
    private JCheckBox jCheckBox48;
    private JCheckBox jCheckBox49;
    private JCheckBox jCheckBox5;
    private JCheckBox jCheckBox50;
    private JCheckBox jCheckBox51;
    private JCheckBox jCheckBox52;
    private JCheckBox jCheckBox53;
    private JCheckBox jCheckBox54;
    private JCheckBox jCheckBox55;
    private JCheckBox jCheckBox56;
    private JCheckBox jCheckBox57;
    private JCheckBox jCheckBox58;
    private JCheckBox jCheckBox59;
    private JCheckBox jCheckBox6;
    private JCheckBox jCheckBox60;
    private JCheckBox jCheckBox61;
    private JCheckBox jCheckBox62;
    private JCheckBox jCheckBox63;
    private JCheckBox jCheckBox64;
    private JCheckBox jCheckBox65;
    private JCheckBox jCheckBox66;
    private JCheckBox jCheckBox67;
    private JCheckBox jCheckBox68;
    private JCheckBox jCheckBox69;
    private JCheckBox jCheckBox7;
    private JCheckBox jCheckBox70;
    private JCheckBox jCheckBox71;
    private JCheckBox jCheckBox72;
    private JCheckBox jCheckBox73;
    private JCheckBox jCheckBox74;
    private JCheckBox jCheckBox75;
    private JCheckBox jCheckBox76;
    private JCheckBox jCheckBox77;
    private JCheckBox jCheckBox78;
    private JCheckBox jCheckBox79;
    private JCheckBox jCheckBox8;
    private JCheckBox jCheckBox80;
    private JCheckBox jCheckBox81;
    private JCheckBox jCheckBox82;
    private JCheckBox jCheckBox83;
    private JCheckBox jCheckBox84;
    private JCheckBox jCheckBox85;
    private JCheckBox jCheckBox86;
    private JCheckBox jCheckBox87;
    private JCheckBox jCheckBox88;
    private JCheckBox jCheckBox89;
    private JCheckBox jCheckBox9;
    private JCheckBox jCheckBox90;
    private JCheckBox jCheckBox91;
    private JCheckBox jCheckBox92;
    private JCheckBox jCheckBox93;
    private JCheckBox jCheckBox94;
    private JCheckBox jCheckBox95;
    private JCheckBox jCheckBox96;
    private JCheckBox jCheckBox97;
    private JCheckBox jCheckBox98;
    private JCheckBox jCheckBox99;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private ButtonGroup ojoDerecho;
    private ButtonGroup ojoIzquierdo;

    public JPSo_VisiometriaDistancias() {
        initComponents();
        this.xOptAO = 0;
        this.xOptOD = 0;
        this.xOptOI = 0;
    }

    private void initComponents() {
        this.ambosOjos = new ButtonGroup();
        this.ojoDerecho = new ButtonGroup();
        this.ojoIzquierdo = new ButtonGroup();
        this.JPAO = new JPanel();
        this.AO1 = new JRadioButton();
        this.AO2 = new JRadioButton();
        this.AO3 = new JRadioButton();
        this.AO4 = new JRadioButton();
        this.AO5 = new JRadioButton();
        this.AO6 = new JRadioButton();
        this.AO7 = new JRadioButton();
        this.AO8 = new JRadioButton();
        this.AO9 = new JRadioButton();
        this.AO10 = new JRadioButton();
        this.jCheckBox1 = new JCheckBox();
        this.jCheckBox2 = new JCheckBox();
        this.jCheckBox3 = new JCheckBox();
        this.jCheckBox4 = new JCheckBox();
        this.jCheckBox5 = new JCheckBox();
        this.jCheckBox6 = new JCheckBox();
        this.jCheckBox7 = new JCheckBox();
        this.jCheckBox8 = new JCheckBox();
        this.jCheckBox9 = new JCheckBox();
        this.jCheckBox10 = new JCheckBox();
        this.jCheckBox11 = new JCheckBox();
        this.jCheckBox12 = new JCheckBox();
        this.jCheckBox13 = new JCheckBox();
        this.jCheckBox14 = new JCheckBox();
        this.jCheckBox15 = new JCheckBox();
        this.jCheckBox16 = new JCheckBox();
        this.jCheckBox17 = new JCheckBox();
        this.jCheckBox18 = new JCheckBox();
        this.jCheckBox19 = new JCheckBox();
        this.jCheckBox20 = new JCheckBox();
        this.jCheckBox21 = new JCheckBox();
        this.jCheckBox22 = new JCheckBox();
        this.jCheckBox23 = new JCheckBox();
        this.jCheckBox24 = new JCheckBox();
        this.jCheckBox25 = new JCheckBox();
        this.jCheckBox26 = new JCheckBox();
        this.jCheckBox27 = new JCheckBox();
        this.jCheckBox28 = new JCheckBox();
        this.jCheckBox29 = new JCheckBox();
        this.jCheckBox30 = new JCheckBox();
        this.jCheckBox31 = new JCheckBox();
        this.jCheckBox32 = new JCheckBox();
        this.jCheckBox33 = new JCheckBox();
        this.jCheckBox34 = new JCheckBox();
        this.jCheckBox35 = new JCheckBox();
        this.jCheckBox36 = new JCheckBox();
        this.jCheckBox37 = new JCheckBox();
        this.jCheckBox38 = new JCheckBox();
        this.jCheckBox39 = new JCheckBox();
        this.jCheckBox40 = new JCheckBox();
        this.jCheckBox41 = new JCheckBox();
        this.jCheckBox42 = new JCheckBox();
        this.jCheckBox43 = new JCheckBox();
        this.jCheckBox44 = new JCheckBox();
        this.jCheckBox45 = new JCheckBox();
        this.jCheckBox46 = new JCheckBox();
        this.jCheckBox47 = new JCheckBox();
        this.jCheckBox48 = new JCheckBox();
        this.jCheckBox49 = new JCheckBox();
        this.jCheckBox50 = new JCheckBox();
        this.jCheckBox51 = new JCheckBox();
        this.jCheckBox52 = new JCheckBox();
        this.jCheckBox53 = new JCheckBox();
        this.jCheckBox54 = new JCheckBox();
        this.jCheckBox55 = new JCheckBox();
        this.jCheckBox56 = new JCheckBox();
        this.jCheckBox57 = new JCheckBox();
        this.jCheckBox58 = new JCheckBox();
        this.jCheckBox59 = new JCheckBox();
        this.jCheckBox60 = new JCheckBox();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.jLabel10 = new JLabel();
        this.JPOD = new JPanel();
        this.OD1 = new JRadioButton();
        this.OD2 = new JRadioButton();
        this.OD3 = new JRadioButton();
        this.OD4 = new JRadioButton();
        this.OD5 = new JRadioButton();
        this.OD6 = new JRadioButton();
        this.OD7 = new JRadioButton();
        this.OD8 = new JRadioButton();
        this.OD9 = new JRadioButton();
        this.OD10 = new JRadioButton();
        this.jCheckBox61 = new JCheckBox();
        this.jCheckBox62 = new JCheckBox();
        this.jCheckBox63 = new JCheckBox();
        this.jCheckBox64 = new JCheckBox();
        this.jCheckBox65 = new JCheckBox();
        this.jCheckBox66 = new JCheckBox();
        this.jCheckBox67 = new JCheckBox();
        this.jCheckBox68 = new JCheckBox();
        this.jCheckBox69 = new JCheckBox();
        this.jCheckBox70 = new JCheckBox();
        this.jCheckBox71 = new JCheckBox();
        this.jCheckBox72 = new JCheckBox();
        this.jCheckBox73 = new JCheckBox();
        this.jCheckBox74 = new JCheckBox();
        this.jCheckBox75 = new JCheckBox();
        this.jCheckBox76 = new JCheckBox();
        this.jCheckBox77 = new JCheckBox();
        this.jCheckBox78 = new JCheckBox();
        this.jCheckBox79 = new JCheckBox();
        this.jCheckBox80 = new JCheckBox();
        this.jCheckBox81 = new JCheckBox();
        this.jCheckBox82 = new JCheckBox();
        this.jCheckBox83 = new JCheckBox();
        this.jCheckBox84 = new JCheckBox();
        this.jCheckBox85 = new JCheckBox();
        this.jCheckBox86 = new JCheckBox();
        this.jCheckBox87 = new JCheckBox();
        this.jCheckBox88 = new JCheckBox();
        this.jCheckBox89 = new JCheckBox();
        this.jCheckBox90 = new JCheckBox();
        this.jCheckBox91 = new JCheckBox();
        this.jCheckBox92 = new JCheckBox();
        this.jCheckBox93 = new JCheckBox();
        this.jCheckBox94 = new JCheckBox();
        this.jCheckBox95 = new JCheckBox();
        this.jCheckBox96 = new JCheckBox();
        this.jCheckBox97 = new JCheckBox();
        this.jCheckBox98 = new JCheckBox();
        this.jCheckBox99 = new JCheckBox();
        this.jCheckBox100 = new JCheckBox();
        this.jCheckBox101 = new JCheckBox();
        this.jCheckBox102 = new JCheckBox();
        this.jCheckBox103 = new JCheckBox();
        this.jCheckBox104 = new JCheckBox();
        this.jCheckBox105 = new JCheckBox();
        this.jCheckBox106 = new JCheckBox();
        this.jCheckBox107 = new JCheckBox();
        this.jCheckBox108 = new JCheckBox();
        this.jCheckBox109 = new JCheckBox();
        this.jCheckBox110 = new JCheckBox();
        this.jCheckBox111 = new JCheckBox();
        this.jCheckBox112 = new JCheckBox();
        this.jCheckBox113 = new JCheckBox();
        this.jCheckBox114 = new JCheckBox();
        this.jCheckBox115 = new JCheckBox();
        this.jCheckBox116 = new JCheckBox();
        this.jCheckBox117 = new JCheckBox();
        this.jCheckBox118 = new JCheckBox();
        this.jCheckBox119 = new JCheckBox();
        this.jCheckBox120 = new JCheckBox();
        this.JPOI = new JPanel();
        this.OI1 = new JRadioButton();
        this.OI2 = new JRadioButton();
        this.OI3 = new JRadioButton();
        this.OI4 = new JRadioButton();
        this.OI5 = new JRadioButton();
        this.OI6 = new JRadioButton();
        this.OI7 = new JRadioButton();
        this.OI8 = new JRadioButton();
        this.OI9 = new JRadioButton();
        this.OI10 = new JRadioButton();
        this.jCheckBox121 = new JCheckBox();
        this.jCheckBox122 = new JCheckBox();
        this.jCheckBox123 = new JCheckBox();
        this.jCheckBox124 = new JCheckBox();
        this.jCheckBox125 = new JCheckBox();
        this.jCheckBox126 = new JCheckBox();
        this.jCheckBox127 = new JCheckBox();
        this.jCheckBox128 = new JCheckBox();
        this.jCheckBox129 = new JCheckBox();
        this.jCheckBox130 = new JCheckBox();
        this.jCheckBox131 = new JCheckBox();
        this.jCheckBox132 = new JCheckBox();
        this.jCheckBox133 = new JCheckBox();
        this.jCheckBox134 = new JCheckBox();
        this.jCheckBox135 = new JCheckBox();
        this.jCheckBox136 = new JCheckBox();
        this.jCheckBox137 = new JCheckBox();
        this.jCheckBox138 = new JCheckBox();
        this.jCheckBox139 = new JCheckBox();
        this.jCheckBox140 = new JCheckBox();
        this.jCheckBox141 = new JCheckBox();
        this.jCheckBox142 = new JCheckBox();
        this.jCheckBox143 = new JCheckBox();
        this.jCheckBox144 = new JCheckBox();
        this.jCheckBox145 = new JCheckBox();
        this.jCheckBox146 = new JCheckBox();
        this.jCheckBox147 = new JCheckBox();
        this.jCheckBox148 = new JCheckBox();
        this.jCheckBox149 = new JCheckBox();
        this.jCheckBox150 = new JCheckBox();
        this.jCheckBox151 = new JCheckBox();
        this.jCheckBox152 = new JCheckBox();
        this.jCheckBox153 = new JCheckBox();
        this.jCheckBox154 = new JCheckBox();
        this.jCheckBox155 = new JCheckBox();
        this.jCheckBox156 = new JCheckBox();
        this.jCheckBox157 = new JCheckBox();
        this.jCheckBox158 = new JCheckBox();
        this.jCheckBox159 = new JCheckBox();
        this.jCheckBox160 = new JCheckBox();
        this.jCheckBox161 = new JCheckBox();
        this.jCheckBox162 = new JCheckBox();
        this.jCheckBox163 = new JCheckBox();
        this.jCheckBox164 = new JCheckBox();
        this.jCheckBox165 = new JCheckBox();
        this.jCheckBox166 = new JCheckBox();
        this.jCheckBox167 = new JCheckBox();
        this.jCheckBox168 = new JCheckBox();
        this.jCheckBox169 = new JCheckBox();
        this.jCheckBox170 = new JCheckBox();
        this.jCheckBox171 = new JCheckBox();
        this.jCheckBox172 = new JCheckBox();
        this.jCheckBox173 = new JCheckBox();
        this.jCheckBox174 = new JCheckBox();
        this.jCheckBox175 = new JCheckBox();
        this.jCheckBox176 = new JCheckBox();
        this.jCheckBox177 = new JCheckBox();
        this.jCheckBox178 = new JCheckBox();
        this.jCheckBox179 = new JCheckBox();
        this.jCheckBox180 = new JCheckBox();
        this.JLLineaAO = new JLabel();
        this.JLOptotipoAO = new JLabel();
        this.JLNivelAO = new JLabel();
        this.JLLineaOD = new JLabel();
        this.JLOptotiposOD = new JLabel();
        this.JLNivelOD = new JLabel();
        this.JLLineaOI = new JLabel();
        this.JLOptotiposOI = new JLabel();
        this.JLNivelOI = new JLabel();
        this.JCBClaAO = new JComboBox<>();
        this.JCBClaOD = new JComboBox<>();
        this.JCBClaOI = new JComboBox<>();
        this.JPAO.setBorder(BorderFactory.createTitledBorder((Border) null, "Ambos Ojos", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JPAO.setName("AO");
        this.ambosOjos.add(this.AO1);
        this.AO1.setFont(new Font("Arial", 1, 12));
        this.AO1.setText("1");
        this.AO1.setName("20/100");
        this.AO1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.1
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.AO1ActionPerformed(evt);
            }
        });
        this.ambosOjos.add(this.AO2);
        this.AO2.setFont(new Font("Arial", 1, 12));
        this.AO2.setText("2");
        this.AO2.setName("20/85");
        this.AO2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.2
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.AO2ActionPerformed(evt);
            }
        });
        this.ambosOjos.add(this.AO3);
        this.AO3.setFont(new Font("Arial", 1, 12));
        this.AO3.setText("3");
        this.AO3.setName("20/70");
        this.AO3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.3
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.AO3ActionPerformed(evt);
            }
        });
        this.ambosOjos.add(this.AO4);
        this.AO4.setFont(new Font("Arial", 1, 12));
        this.AO4.setText("4");
        this.AO4.setName("20/50");
        this.AO4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.4
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.AO4ActionPerformed(evt);
            }
        });
        this.ambosOjos.add(this.AO5);
        this.AO5.setFont(new Font("Arial", 1, 12));
        this.AO5.setText("5");
        this.AO5.setName("20/40");
        this.AO5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.5
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.AO5ActionPerformed(evt);
            }
        });
        this.ambosOjos.add(this.AO6);
        this.AO6.setFont(new Font("Arial", 1, 12));
        this.AO6.setText("6");
        this.AO6.setName("20/30");
        this.AO6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.6
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.AO6ActionPerformed(evt);
            }
        });
        this.ambosOjos.add(this.AO7);
        this.AO7.setFont(new Font("Arial", 1, 12));
        this.AO7.setText("7");
        this.AO7.setName("20/25");
        this.AO7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.7
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.AO7ActionPerformed(evt);
            }
        });
        this.ambosOjos.add(this.AO8);
        this.AO8.setFont(new Font("Arial", 1, 12));
        this.AO8.setText("8");
        this.AO8.setName("20/20");
        this.AO8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.8
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.AO8ActionPerformed(evt);
            }
        });
        this.ambosOjos.add(this.AO9);
        this.AO9.setFont(new Font("Arial", 1, 12));
        this.AO9.setText("9");
        this.AO9.setName("20/15");
        this.AO9.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.9
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.AO9ActionPerformed(evt);
            }
        });
        this.ambosOjos.add(this.AO10);
        this.AO10.setFont(new Font("Arial", 1, 12));
        this.AO10.setText("10");
        this.AO10.setName("20/10");
        this.AO10.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.10
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.AO10ActionPerformed(evt);
            }
        });
        this.jCheckBox1.setFont(new Font("Arial", 1, 12));
        this.jCheckBox1.setForeground(Color.blue);
        this.jCheckBox1.setText("C");
        this.jCheckBox1.setEnabled(false);
        this.jCheckBox1.setName("AO1");
        this.jCheckBox1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.11
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox2.setFont(new Font("Arial", 1, 12));
        this.jCheckBox2.setForeground(Color.blue);
        this.jCheckBox2.setText("H");
        this.jCheckBox2.setEnabled(false);
        this.jCheckBox2.setName("AO1");
        this.jCheckBox2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.12
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox3.setFont(new Font("Arial", 1, 12));
        this.jCheckBox3.setForeground(Color.blue);
        this.jCheckBox3.setText("A");
        this.jCheckBox3.setEnabled(false);
        this.jCheckBox3.setName("AO1");
        this.jCheckBox3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.13
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox4.setFont(new Font("Arial", 1, 12));
        this.jCheckBox4.setForeground(Color.blue);
        this.jCheckBox4.setText("P");
        this.jCheckBox4.setEnabled(false);
        this.jCheckBox4.setName("AO1");
        this.jCheckBox4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.14
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox5.setFont(new Font("Arial", 1, 12));
        this.jCheckBox5.setForeground(Color.blue);
        this.jCheckBox5.setText("V");
        this.jCheckBox5.setEnabled(false);
        this.jCheckBox5.setName("AO1");
        this.jCheckBox5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.15
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox6.setFont(new Font("Arial", 1, 12));
        this.jCheckBox6.setForeground(Color.blue);
        this.jCheckBox6.setText("E");
        this.jCheckBox6.setEnabled(false);
        this.jCheckBox6.setName("AO1");
        this.jCheckBox6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.16
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox7.setFont(new Font("Arial", 1, 12));
        this.jCheckBox7.setForeground(Color.blue);
        this.jCheckBox7.setText("U");
        this.jCheckBox7.setEnabled(false);
        this.jCheckBox7.setName("AO2");
        this.jCheckBox7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.17
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox8.setFont(new Font("Arial", 1, 12));
        this.jCheckBox8.setForeground(Color.blue);
        this.jCheckBox8.setText("Z");
        this.jCheckBox8.setEnabled(false);
        this.jCheckBox8.setName("AO2");
        this.jCheckBox8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.18
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox9.setFont(new Font("Arial", 1, 12));
        this.jCheckBox9.setForeground(Color.blue);
        this.jCheckBox9.setText("T");
        this.jCheckBox9.setEnabled(false);
        this.jCheckBox9.setName("AO2");
        this.jCheckBox9.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.19
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox10.setFont(new Font("Arial", 1, 12));
        this.jCheckBox10.setForeground(Color.blue);
        this.jCheckBox10.setText("L");
        this.jCheckBox10.setEnabled(false);
        this.jCheckBox10.setName("AO2");
        this.jCheckBox10.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.20
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox11.setFont(new Font("Arial", 1, 12));
        this.jCheckBox11.setForeground(Color.blue);
        this.jCheckBox11.setText("E");
        this.jCheckBox11.setEnabled(false);
        this.jCheckBox11.setName("AO2");
        this.jCheckBox11.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.21
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox12.setFont(new Font("Arial", 1, 12));
        this.jCheckBox12.setForeground(Color.blue);
        this.jCheckBox12.setText("K");
        this.jCheckBox12.setEnabled(false);
        this.jCheckBox12.setName("AO2");
        this.jCheckBox12.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.22
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox13.setFont(new Font("Arial", 1, 12));
        this.jCheckBox13.setForeground(Color.blue);
        this.jCheckBox13.setText("T");
        this.jCheckBox13.setEnabled(false);
        this.jCheckBox13.setName("AO3");
        this.jCheckBox13.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.23
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox14.setFont(new Font("Arial", 1, 12));
        this.jCheckBox14.setForeground(Color.blue);
        this.jCheckBox14.setText("P");
        this.jCheckBox14.setEnabled(false);
        this.jCheckBox14.setName("AO3");
        this.jCheckBox14.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.24
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox15.setFont(new Font("Arial", 1, 12));
        this.jCheckBox15.setForeground(Color.blue);
        this.jCheckBox15.setText("Z");
        this.jCheckBox15.setEnabled(false);
        this.jCheckBox15.setName("AO3");
        this.jCheckBox15.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.25
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox16.setFont(new Font("Arial", 1, 12));
        this.jCheckBox16.setForeground(Color.blue);
        this.jCheckBox16.setText("F");
        this.jCheckBox16.setEnabled(false);
        this.jCheckBox16.setName("AO3");
        this.jCheckBox16.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.26
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox17.setFont(new Font("Arial", 1, 12));
        this.jCheckBox17.setForeground(Color.blue);
        this.jCheckBox17.setText("K");
        this.jCheckBox17.setEnabled(false);
        this.jCheckBox17.setName("AO3");
        this.jCheckBox17.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.27
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox18.setFont(new Font("Arial", 1, 12));
        this.jCheckBox18.setForeground(Color.blue);
        this.jCheckBox18.setText("V");
        this.jCheckBox18.setEnabled(false);
        this.jCheckBox18.setName("AO3");
        this.jCheckBox18.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.28
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox19.setFont(new Font("Arial", 1, 12));
        this.jCheckBox19.setForeground(Color.blue);
        this.jCheckBox19.setText("A");
        this.jCheckBox19.setEnabled(false);
        this.jCheckBox19.setName("AO4");
        this.jCheckBox19.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.29
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox20.setFont(new Font("Arial", 1, 12));
        this.jCheckBox20.setForeground(Color.blue);
        this.jCheckBox20.setText("R");
        this.jCheckBox20.setEnabled(false);
        this.jCheckBox20.setName("AO4");
        this.jCheckBox20.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.30
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox21.setFont(new Font("Arial", 1, 12));
        this.jCheckBox21.setForeground(Color.blue);
        this.jCheckBox21.setText("P");
        this.jCheckBox21.setEnabled(false);
        this.jCheckBox21.setName("AO4");
        this.jCheckBox21.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.31
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox22.setFont(new Font("Arial", 1, 12));
        this.jCheckBox22.setForeground(Color.blue);
        this.jCheckBox22.setText("V");
        this.jCheckBox22.setEnabled(false);
        this.jCheckBox22.setName("AO4");
        this.jCheckBox22.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.32
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox23.setFont(new Font("Arial", 1, 12));
        this.jCheckBox23.setForeground(Color.blue);
        this.jCheckBox23.setText("F");
        this.jCheckBox23.setEnabled(false);
        this.jCheckBox23.setName("AO4");
        this.jCheckBox23.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.33
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox24.setFont(new Font("Arial", 1, 12));
        this.jCheckBox24.setForeground(Color.blue);
        this.jCheckBox24.setText("E");
        this.jCheckBox24.setEnabled(false);
        this.jCheckBox24.setName("AO4");
        this.jCheckBox24.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.34
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox25.setFont(new Font("Arial", 1, 12));
        this.jCheckBox25.setForeground(Color.blue);
        this.jCheckBox25.setText("H");
        this.jCheckBox25.setEnabled(false);
        this.jCheckBox25.setName("AO5");
        this.jCheckBox25.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.35
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox26.setFont(new Font("Arial", 1, 12));
        this.jCheckBox26.setForeground(Color.blue);
        this.jCheckBox26.setText("P");
        this.jCheckBox26.setEnabled(false);
        this.jCheckBox26.setName("AO5");
        this.jCheckBox26.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.36
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox27.setFont(new Font("Arial", 1, 12));
        this.jCheckBox27.setForeground(Color.blue);
        this.jCheckBox27.setText("E");
        this.jCheckBox27.setEnabled(false);
        this.jCheckBox27.setName("AO5");
        this.jCheckBox27.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.37
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox28.setFont(new Font("Arial", 1, 12));
        this.jCheckBox28.setForeground(Color.blue);
        this.jCheckBox28.setText("T");
        this.jCheckBox28.setEnabled(false);
        this.jCheckBox28.setName("AO5");
        this.jCheckBox28.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.38
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox29.setFont(new Font("Arial", 1, 12));
        this.jCheckBox29.setForeground(Color.blue);
        this.jCheckBox29.setText("Z");
        this.jCheckBox29.setEnabled(false);
        this.jCheckBox29.setName("AO5");
        this.jCheckBox29.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.39
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox30.setFont(new Font("Arial", 1, 12));
        this.jCheckBox30.setForeground(Color.blue);
        this.jCheckBox30.setText("K");
        this.jCheckBox30.setEnabled(false);
        this.jCheckBox30.setName("AO5");
        this.jCheckBox30.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.40
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox31.setFont(new Font("Arial", 1, 12));
        this.jCheckBox31.setForeground(Color.blue);
        this.jCheckBox31.setText("C");
        this.jCheckBox31.setEnabled(false);
        this.jCheckBox31.setName("AO6");
        this.jCheckBox31.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.41
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox32.setFont(new Font("Arial", 1, 12));
        this.jCheckBox32.setForeground(Color.blue);
        this.jCheckBox32.setText("T");
        this.jCheckBox32.setEnabled(false);
        this.jCheckBox32.setName("AO6");
        this.jCheckBox32.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.42
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox33.setFont(new Font("Arial", 1, 12));
        this.jCheckBox33.setForeground(Color.blue);
        this.jCheckBox33.setText("L");
        this.jCheckBox33.setEnabled(false);
        this.jCheckBox33.setName("AO6");
        this.jCheckBox33.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.43
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox34.setFont(new Font("Arial", 1, 12));
        this.jCheckBox34.setForeground(Color.blue);
        this.jCheckBox34.setText("U");
        this.jCheckBox34.setEnabled(false);
        this.jCheckBox34.setName("AO6");
        this.jCheckBox34.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.44
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox35.setFont(new Font("Arial", 1, 12));
        this.jCheckBox35.setForeground(Color.blue);
        this.jCheckBox35.setText("P");
        this.jCheckBox35.setEnabled(false);
        this.jCheckBox35.setName("AO6");
        this.jCheckBox35.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.45
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox36.setFont(new Font("Arial", 1, 12));
        this.jCheckBox36.setForeground(Color.blue);
        this.jCheckBox36.setText("Z");
        this.jCheckBox36.setEnabled(false);
        this.jCheckBox36.setName("AO6");
        this.jCheckBox36.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.46
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox37.setFont(new Font("Arial", 1, 12));
        this.jCheckBox37.setForeground(Color.blue);
        this.jCheckBox37.setText("H");
        this.jCheckBox37.setEnabled(false);
        this.jCheckBox37.setName("AO7");
        this.jCheckBox37.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.47
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox38.setFont(new Font("Arial", 1, 12));
        this.jCheckBox38.setForeground(Color.blue);
        this.jCheckBox38.setText("R");
        this.jCheckBox38.setEnabled(false);
        this.jCheckBox38.setName("AO7");
        this.jCheckBox38.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.48
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox39.setFont(new Font("Arial", 1, 12));
        this.jCheckBox39.setForeground(Color.blue);
        this.jCheckBox39.setText("P");
        this.jCheckBox39.setEnabled(false);
        this.jCheckBox39.setName("AO7");
        this.jCheckBox39.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.49
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox40.setFont(new Font("Arial", 1, 12));
        this.jCheckBox40.setForeground(Color.blue);
        this.jCheckBox40.setText("C");
        this.jCheckBox40.setEnabled(false);
        this.jCheckBox40.setName("AO7");
        this.jCheckBox40.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.50
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox41.setFont(new Font("Arial", 1, 12));
        this.jCheckBox41.setForeground(Color.blue);
        this.jCheckBox41.setText("A");
        this.jCheckBox41.setEnabled(false);
        this.jCheckBox41.setName("AO7");
        this.jCheckBox41.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.51
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox42.setFont(new Font("Arial", 1, 12));
        this.jCheckBox42.setForeground(Color.blue);
        this.jCheckBox42.setText("U");
        this.jCheckBox42.setEnabled(false);
        this.jCheckBox42.setName("AO7");
        this.jCheckBox42.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.52
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox43.setFont(new Font("Arial", 1, 12));
        this.jCheckBox43.setForeground(Color.blue);
        this.jCheckBox43.setText("P");
        this.jCheckBox43.setEnabled(false);
        this.jCheckBox43.setName("AO8");
        this.jCheckBox43.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.53
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox44.setFont(new Font("Arial", 1, 12));
        this.jCheckBox44.setForeground(Color.blue);
        this.jCheckBox44.setText("F");
        this.jCheckBox44.setEnabled(false);
        this.jCheckBox44.setName("AO8");
        this.jCheckBox44.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.54
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox45.setFont(new Font("Arial", 1, 12));
        this.jCheckBox45.setForeground(Color.blue);
        this.jCheckBox45.setText("Z");
        this.jCheckBox45.setEnabled(false);
        this.jCheckBox45.setName("AO8");
        this.jCheckBox45.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.55
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox46.setFont(new Font("Arial", 1, 12));
        this.jCheckBox46.setForeground(Color.blue);
        this.jCheckBox46.setText("H");
        this.jCheckBox46.setEnabled(false);
        this.jCheckBox46.setName("AO8");
        this.jCheckBox46.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.56
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox47.setFont(new Font("Arial", 1, 12));
        this.jCheckBox47.setForeground(Color.blue);
        this.jCheckBox47.setText("K");
        this.jCheckBox47.setEnabled(false);
        this.jCheckBox47.setName("AO8");
        this.jCheckBox47.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.57
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox48.setFont(new Font("Arial", 1, 12));
        this.jCheckBox48.setForeground(Color.blue);
        this.jCheckBox48.setText("R");
        this.jCheckBox48.setEnabled(false);
        this.jCheckBox48.setName("AO8");
        this.jCheckBox48.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.58
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox49.setFont(new Font("Arial", 1, 12));
        this.jCheckBox49.setForeground(Color.blue);
        this.jCheckBox49.setText("E");
        this.jCheckBox49.setEnabled(false);
        this.jCheckBox49.setName("AO9");
        this.jCheckBox49.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.59
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox50.setFont(new Font("Arial", 1, 12));
        this.jCheckBox50.setForeground(Color.blue);
        this.jCheckBox50.setText("T");
        this.jCheckBox50.setEnabled(false);
        this.jCheckBox50.setName("AO9");
        this.jCheckBox50.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.60
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox51.setFont(new Font("Arial", 1, 12));
        this.jCheckBox51.setForeground(Color.blue);
        this.jCheckBox51.setText("P");
        this.jCheckBox51.setEnabled(false);
        this.jCheckBox51.setName("AO9");
        this.jCheckBox51.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.61
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox52.setFont(new Font("Arial", 1, 12));
        this.jCheckBox52.setForeground(Color.blue);
        this.jCheckBox52.setText("K");
        this.jCheckBox52.setEnabled(false);
        this.jCheckBox52.setName("AO9");
        this.jCheckBox52.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.62
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox53.setFont(new Font("Arial", 1, 12));
        this.jCheckBox53.setForeground(Color.blue);
        this.jCheckBox53.setText("N");
        this.jCheckBox53.setEnabled(false);
        this.jCheckBox53.setName("AO9");
        this.jCheckBox53.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.63
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox54.setFont(new Font("Arial", 1, 12));
        this.jCheckBox54.setForeground(Color.blue);
        this.jCheckBox54.setText("F");
        this.jCheckBox54.setEnabled(false);
        this.jCheckBox54.setName("AO9");
        this.jCheckBox54.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.64
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox55.setFont(new Font("Arial", 1, 12));
        this.jCheckBox55.setForeground(Color.blue);
        this.jCheckBox55.setText("K");
        this.jCheckBox55.setEnabled(false);
        this.jCheckBox55.setName("AO10");
        this.jCheckBox55.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.65
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox56.setFont(new Font("Arial", 1, 12));
        this.jCheckBox56.setForeground(Color.blue);
        this.jCheckBox56.setText("H");
        this.jCheckBox56.setEnabled(false);
        this.jCheckBox56.setName("AO10");
        this.jCheckBox56.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.66
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox57.setFont(new Font("Arial", 1, 12));
        this.jCheckBox57.setForeground(Color.blue);
        this.jCheckBox57.setText("C");
        this.jCheckBox57.setEnabled(false);
        this.jCheckBox57.setName("AO10");
        this.jCheckBox57.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.67
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox58.setFont(new Font("Arial", 1, 12));
        this.jCheckBox58.setForeground(Color.blue);
        this.jCheckBox58.setText("P");
        this.jCheckBox58.setEnabled(false);
        this.jCheckBox58.setName("AO10");
        this.jCheckBox58.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.68
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox59.setFont(new Font("Arial", 1, 12));
        this.jCheckBox59.setForeground(Color.blue);
        this.jCheckBox59.setText("F");
        this.jCheckBox59.setEnabled(false);
        this.jCheckBox59.setName("AO10");
        this.jCheckBox59.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.69
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jCheckBox60.setFont(new Font("Arial", 1, 12));
        this.jCheckBox60.setForeground(Color.blue);
        this.jCheckBox60.setText("L");
        this.jCheckBox60.setEnabled(false);
        this.jCheckBox60.setName("AO10");
        this.jCheckBox60.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.70
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoCheck(evt);
            }
        });
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("20/100");
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText("20/85");
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setText("20/70");
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setText("20/50");
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setText("20/40");
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setText("20/30");
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setText("20/25");
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setText("20/20");
        this.jLabel9.setFont(new Font("Arial", 1, 12));
        this.jLabel9.setText("20/15");
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setText("20/10");
        GroupLayout JPAOLayout = new GroupLayout(this.JPAO);
        this.JPAO.setLayout(JPAOLayout);
        JPAOLayout.setHorizontalGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPAOLayout.createSequentialGroup().addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAOLayout.createSequentialGroup().addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, -2, 44, -2).addComponent(this.jLabel2, -2, 44, -2).addComponent(this.jLabel3, -2, 44, -2).addComponent(this.jLabel4, -2, 44, -2).addComponent(this.jLabel5, -2, 44, -2).addComponent(this.jLabel6, -2, 44, -2).addComponent(this.jLabel7, -2, 44, -2).addComponent(this.jLabel8, -2, 44, -2).addComponent(this.jLabel9, -2, 44, -2)).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPAOLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jLabel10, -2, 44, -2))).addGap(0, 0, 0).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAOLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAOLayout.createSequentialGroup().addComponent(this.AO9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox49).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox50).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox51).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox52).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox53).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox54)).addGroup(JPAOLayout.createSequentialGroup().addComponent(this.AO8).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox43).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox44).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox45).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox46).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox47).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox48)).addGroup(JPAOLayout.createSequentialGroup().addComponent(this.AO7).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox37).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox38).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox39).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox40).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox41).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox42)).addGroup(JPAOLayout.createSequentialGroup().addComponent(this.AO6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox31).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox32).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox33).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox34).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox35).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox36)).addGroup(JPAOLayout.createSequentialGroup().addComponent(this.AO5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox25).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox26).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox27).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox28).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox29).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox30)).addGroup(JPAOLayout.createSequentialGroup().addComponent(this.AO4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox19).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox20).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox21).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox22).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox23).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox24)).addGroup(JPAOLayout.createSequentialGroup().addComponent(this.AO3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox13).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox14).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox15).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox16).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox17).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox18)).addGroup(JPAOLayout.createSequentialGroup().addComponent(this.AO2).addGap(0, 0, 0).addComponent(this.jCheckBox7).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox8).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox10).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox11).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox12)).addGroup(JPAOLayout.createSequentialGroup().addComponent(this.AO1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox6)))).addGroup(JPAOLayout.createSequentialGroup().addComponent(this.AO10).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox55).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox56).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox57).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox58).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox59).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox60))).addGap(3, 3, 3)));
        JPAOLayout.setVerticalGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAOLayout.createSequentialGroup().addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.AO1).addComponent(this.jCheckBox1).addComponent(this.jCheckBox2).addComponent(this.jCheckBox3).addComponent(this.jCheckBox4).addComponent(this.jCheckBox5).addComponent(this.jCheckBox6).addComponent(this.jLabel1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCheckBox7).addComponent(this.jCheckBox8).addComponent(this.jCheckBox9).addComponent(this.jCheckBox10).addComponent(this.jCheckBox11).addComponent(this.jCheckBox12)).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.AO2).addComponent(this.jLabel2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCheckBox13).addComponent(this.jCheckBox14).addComponent(this.jCheckBox15).addComponent(this.jCheckBox16).addComponent(this.jCheckBox17).addComponent(this.jCheckBox18)).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.AO3).addComponent(this.jLabel3))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCheckBox19).addComponent(this.jCheckBox20).addComponent(this.jCheckBox21).addComponent(this.jCheckBox22).addComponent(this.jCheckBox23).addComponent(this.jCheckBox24)).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.AO4).addComponent(this.jLabel4))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCheckBox25).addComponent(this.jCheckBox26).addComponent(this.jCheckBox27).addComponent(this.jCheckBox28).addComponent(this.jCheckBox29).addComponent(this.jCheckBox30)).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.AO5).addComponent(this.jLabel5))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCheckBox31).addComponent(this.jCheckBox32).addComponent(this.jCheckBox33).addComponent(this.jCheckBox34).addComponent(this.jCheckBox35).addComponent(this.jCheckBox36)).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.AO6).addComponent(this.jLabel6))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCheckBox37).addComponent(this.jCheckBox38).addComponent(this.jCheckBox39).addComponent(this.jCheckBox40).addComponent(this.jCheckBox41).addComponent(this.jCheckBox42)).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.AO7).addComponent(this.jLabel7))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCheckBox43).addComponent(this.jCheckBox44).addComponent(this.jCheckBox45).addComponent(this.jCheckBox46).addComponent(this.jCheckBox47).addComponent(this.jCheckBox48)).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.AO8).addComponent(this.jLabel8))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCheckBox49).addComponent(this.jCheckBox50).addComponent(this.jCheckBox51).addComponent(this.jCheckBox52).addComponent(this.jCheckBox53).addComponent(this.jCheckBox54)).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.AO9).addComponent(this.jLabel9))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCheckBox55).addComponent(this.jCheckBox56).addComponent(this.jCheckBox57).addComponent(this.jCheckBox58).addComponent(this.jCheckBox59).addComponent(this.jCheckBox60)).addGroup(JPAOLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.AO10).addComponent(this.jLabel10)))));
        this.JPOD.setBorder(BorderFactory.createTitledBorder((Border) null, "Ojo Derecho", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JPOD.setName("OD");
        this.ojoDerecho.add(this.OD1);
        this.OD1.setFont(new Font("Arial", 1, 12));
        this.OD1.setText("1");
        this.OD1.setName("20/100");
        this.OD1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.71
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.OD1ActionPerformed(evt);
            }
        });
        this.ojoDerecho.add(this.OD2);
        this.OD2.setFont(new Font("Arial", 1, 12));
        this.OD2.setText("2");
        this.OD2.setName("20/85");
        this.OD2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.72
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.OD2ActionPerformed(evt);
            }
        });
        this.ojoDerecho.add(this.OD3);
        this.OD3.setFont(new Font("Arial", 1, 12));
        this.OD3.setText("3");
        this.OD3.setName("20/70");
        this.OD3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.73
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.OD3ActionPerformed(evt);
            }
        });
        this.ojoDerecho.add(this.OD4);
        this.OD4.setFont(new Font("Arial", 1, 12));
        this.OD4.setText("4");
        this.OD4.setName("20/50");
        this.OD4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.74
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.OD4ActionPerformed(evt);
            }
        });
        this.ojoDerecho.add(this.OD5);
        this.OD5.setFont(new Font("Arial", 1, 12));
        this.OD5.setText("5");
        this.OD5.setName("20/40");
        this.OD5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.75
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.OD5ActionPerformed(evt);
            }
        });
        this.ojoDerecho.add(this.OD6);
        this.OD6.setFont(new Font("Arial", 1, 12));
        this.OD6.setText("6");
        this.OD6.setName("20/30");
        this.OD6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.76
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.OD6ActionPerformed(evt);
            }
        });
        this.ojoDerecho.add(this.OD7);
        this.OD7.setFont(new Font("Arial", 1, 12));
        this.OD7.setText("7");
        this.OD7.setName("20/25");
        this.OD7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.77
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.OD7ActionPerformed(evt);
            }
        });
        this.ojoDerecho.add(this.OD8);
        this.OD8.setFont(new Font("Arial", 1, 12));
        this.OD8.setText("8");
        this.OD8.setName("20/20");
        this.OD8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.78
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.OD8ActionPerformed(evt);
            }
        });
        this.ojoDerecho.add(this.OD9);
        this.OD9.setFont(new Font("Arial", 1, 12));
        this.OD9.setText("9");
        this.OD9.setName("20/15");
        this.OD9.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.79
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.OD9ActionPerformed(evt);
            }
        });
        this.ojoDerecho.add(this.OD10);
        this.OD10.setFont(new Font("Arial", 1, 12));
        this.OD10.setText("10");
        this.OD10.setName("20/10");
        this.OD10.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.80
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.OD10ActionPerformed(evt);
            }
        });
        this.jCheckBox61.setFont(new Font("Arial", 1, 12));
        this.jCheckBox61.setForeground(Color.blue);
        this.jCheckBox61.setText("P");
        this.jCheckBox61.setEnabled(false);
        this.jCheckBox61.setName("OD1");
        this.jCheckBox61.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.81
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox62.setFont(new Font("Arial", 1, 12));
        this.jCheckBox62.setForeground(Color.blue);
        this.jCheckBox62.setText("H");
        this.jCheckBox62.setEnabled(false);
        this.jCheckBox62.setName("OD1");
        this.jCheckBox62.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.82
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox63.setFont(new Font("Arial", 1, 12));
        this.jCheckBox63.setForeground(Color.blue);
        this.jCheckBox63.setText("C");
        this.jCheckBox63.setEnabled(false);
        this.jCheckBox63.setName("OD1");
        this.jCheckBox63.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.83
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox64.setFont(new Font("Arial", 1, 12));
        this.jCheckBox64.setForeground(Color.blue);
        this.jCheckBox64.setText("V");
        this.jCheckBox64.setEnabled(false);
        this.jCheckBox64.setName("OD1");
        this.jCheckBox64.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.84
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox65.setFont(new Font("Arial", 1, 12));
        this.jCheckBox65.setForeground(Color.blue);
        this.jCheckBox65.setText("Z");
        this.jCheckBox65.setEnabled(false);
        this.jCheckBox65.setName("OD1");
        this.jCheckBox65.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.85
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox66.setFont(new Font("Arial", 1, 12));
        this.jCheckBox66.setForeground(Color.blue);
        this.jCheckBox66.setText("E");
        this.jCheckBox66.setEnabled(false);
        this.jCheckBox66.setName("OD1");
        this.jCheckBox66.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.86
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox67.setFont(new Font("Arial", 1, 12));
        this.jCheckBox67.setForeground(Color.blue);
        this.jCheckBox67.setText("T");
        this.jCheckBox67.setEnabled(false);
        this.jCheckBox67.setName("OD2");
        this.jCheckBox67.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.87
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox68.setFont(new Font("Arial", 1, 12));
        this.jCheckBox68.setForeground(Color.blue);
        this.jCheckBox68.setText("P");
        this.jCheckBox68.setEnabled(false);
        this.jCheckBox68.setName("OD2");
        this.jCheckBox68.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.88
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox69.setFont(new Font("Arial", 1, 12));
        this.jCheckBox69.setForeground(Color.blue);
        this.jCheckBox69.setText("Z");
        this.jCheckBox69.setEnabled(false);
        this.jCheckBox69.setName("OD2");
        this.jCheckBox69.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.89
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox70.setFont(new Font("Arial", 1, 12));
        this.jCheckBox70.setForeground(Color.blue);
        this.jCheckBox70.setText("F");
        this.jCheckBox70.setEnabled(false);
        this.jCheckBox70.setName("OD2");
        this.jCheckBox70.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.90
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox71.setFont(new Font("Arial", 1, 12));
        this.jCheckBox71.setForeground(Color.blue);
        this.jCheckBox71.setText("K");
        this.jCheckBox71.setEnabled(false);
        this.jCheckBox71.setName("OD2");
        this.jCheckBox71.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.91
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox72.setFont(new Font("Arial", 1, 12));
        this.jCheckBox72.setForeground(Color.blue);
        this.jCheckBox72.setText("V");
        this.jCheckBox72.setEnabled(false);
        this.jCheckBox72.setName("OD2");
        this.jCheckBox72.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.92
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox73.setFont(new Font("Arial", 1, 12));
        this.jCheckBox73.setForeground(Color.blue);
        this.jCheckBox73.setText("C");
        this.jCheckBox73.setEnabled(false);
        this.jCheckBox73.setName("OD3");
        this.jCheckBox73.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.93
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox74.setFont(new Font("Arial", 1, 12));
        this.jCheckBox74.setForeground(Color.blue);
        this.jCheckBox74.setText("H");
        this.jCheckBox74.setEnabled(false);
        this.jCheckBox74.setName("OD3");
        this.jCheckBox74.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.94
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox75.setFont(new Font("Arial", 1, 12));
        this.jCheckBox75.setForeground(Color.blue);
        this.jCheckBox75.setText("V");
        this.jCheckBox75.setEnabled(false);
        this.jCheckBox75.setName("OD3");
        this.jCheckBox75.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.95
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox76.setFont(new Font("Arial", 1, 12));
        this.jCheckBox76.setForeground(Color.blue);
        this.jCheckBox76.setText("F");
        this.jCheckBox76.setEnabled(false);
        this.jCheckBox76.setName("OD3");
        this.jCheckBox76.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.96
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox77.setFont(new Font("Arial", 1, 12));
        this.jCheckBox77.setForeground(Color.blue);
        this.jCheckBox77.setText("R");
        this.jCheckBox77.setEnabled(false);
        this.jCheckBox77.setName("OD3");
        this.jCheckBox77.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.97
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox78.setFont(new Font("Arial", 1, 12));
        this.jCheckBox78.setForeground(Color.blue);
        this.jCheckBox78.setText("L");
        this.jCheckBox78.setEnabled(false);
        this.jCheckBox78.setName("OD3");
        this.jCheckBox78.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.98
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox79.setFont(new Font("Arial", 1, 12));
        this.jCheckBox79.setForeground(Color.blue);
        this.jCheckBox79.setText("K");
        this.jCheckBox79.setEnabled(false);
        this.jCheckBox79.setName("OD4");
        this.jCheckBox79.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.99
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox80.setFont(new Font("Arial", 1, 12));
        this.jCheckBox80.setForeground(Color.blue);
        this.jCheckBox80.setText("C");
        this.jCheckBox80.setEnabled(false);
        this.jCheckBox80.setName("OD4");
        this.jCheckBox80.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.100
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox81.setFont(new Font("Arial", 1, 12));
        this.jCheckBox81.setForeground(Color.blue);
        this.jCheckBox81.setText("L");
        this.jCheckBox81.setEnabled(false);
        this.jCheckBox81.setName("OD4");
        this.jCheckBox81.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.101
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox82.setFont(new Font("Arial", 1, 12));
        this.jCheckBox82.setForeground(Color.blue);
        this.jCheckBox82.setText("R");
        this.jCheckBox82.setEnabled(false);
        this.jCheckBox82.setName("OD4");
        this.jCheckBox82.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.102
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox83.setFont(new Font("Arial", 1, 12));
        this.jCheckBox83.setForeground(Color.blue);
        this.jCheckBox83.setText("H");
        this.jCheckBox83.setEnabled(false);
        this.jCheckBox83.setName("OD4");
        this.jCheckBox83.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.103
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox84.setFont(new Font("Arial", 1, 12));
        this.jCheckBox84.setForeground(Color.blue);
        this.jCheckBox84.setText("E");
        this.jCheckBox84.setEnabled(false);
        this.jCheckBox84.setName("OD4");
        this.jCheckBox84.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.104
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox85.setFont(new Font("Arial", 1, 12));
        this.jCheckBox85.setForeground(Color.blue);
        this.jCheckBox85.setText("A");
        this.jCheckBox85.setEnabled(false);
        this.jCheckBox85.setName("OD5");
        this.jCheckBox85.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.105
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox86.setFont(new Font("Arial", 1, 12));
        this.jCheckBox86.setForeground(Color.blue);
        this.jCheckBox86.setText("U");
        this.jCheckBox86.setEnabled(false);
        this.jCheckBox86.setName("OD5");
        this.jCheckBox86.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.106
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox87.setFont(new Font("Arial", 1, 12));
        this.jCheckBox87.setForeground(Color.blue);
        this.jCheckBox87.setText("J");
        this.jCheckBox87.setEnabled(false);
        this.jCheckBox87.setName("OD5");
        this.jCheckBox87.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.107
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox88.setFont(new Font("Arial", 1, 12));
        this.jCheckBox88.setForeground(Color.blue);
        this.jCheckBox88.setText("T");
        this.jCheckBox88.setEnabled(false);
        this.jCheckBox88.setName("OD5");
        this.jCheckBox88.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.108
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox89.setFont(new Font("Arial", 1, 12));
        this.jCheckBox89.setForeground(Color.blue);
        this.jCheckBox89.setText("P");
        this.jCheckBox89.setEnabled(false);
        this.jCheckBox89.setName("OD5");
        this.jCheckBox89.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.109
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox90.setFont(new Font("Arial", 1, 12));
        this.jCheckBox90.setForeground(Color.blue);
        this.jCheckBox90.setText("H");
        this.jCheckBox90.setEnabled(false);
        this.jCheckBox90.setName("OD5");
        this.jCheckBox90.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.110
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox91.setFont(new Font("Arial", 1, 12));
        this.jCheckBox91.setForeground(Color.blue);
        this.jCheckBox91.setText("C");
        this.jCheckBox91.setEnabled(false);
        this.jCheckBox91.setName("OD6");
        this.jCheckBox91.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.111
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox92.setFont(new Font("Arial", 1, 12));
        this.jCheckBox92.setForeground(Color.blue);
        this.jCheckBox92.setText("H");
        this.jCheckBox92.setEnabled(false);
        this.jCheckBox92.setName("OD6");
        this.jCheckBox92.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.112
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox93.setFont(new Font("Arial", 1, 12));
        this.jCheckBox93.setForeground(Color.blue);
        this.jCheckBox93.setText("A");
        this.jCheckBox93.setEnabled(false);
        this.jCheckBox93.setName("OD6");
        this.jCheckBox93.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.113
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox94.setFont(new Font("Arial", 1, 12));
        this.jCheckBox94.setForeground(Color.blue);
        this.jCheckBox94.setText("P");
        this.jCheckBox94.setEnabled(false);
        this.jCheckBox94.setName("OD6");
        this.jCheckBox94.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.114
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox95.setFont(new Font("Arial", 1, 12));
        this.jCheckBox95.setForeground(Color.blue);
        this.jCheckBox95.setText("V");
        this.jCheckBox95.setEnabled(false);
        this.jCheckBox95.setName("OD6");
        this.jCheckBox95.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.115
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox96.setFont(new Font("Arial", 1, 12));
        this.jCheckBox96.setForeground(Color.blue);
        this.jCheckBox96.setText("A");
        this.jCheckBox96.setEnabled(false);
        this.jCheckBox96.setName("OD6");
        this.jCheckBox96.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.116
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox97.setFont(new Font("Arial", 1, 12));
        this.jCheckBox97.setForeground(Color.blue);
        this.jCheckBox97.setText("N");
        this.jCheckBox97.setEnabled(false);
        this.jCheckBox97.setName("OD7");
        this.jCheckBox97.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.117
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox98.setFont(new Font("Arial", 1, 12));
        this.jCheckBox98.setForeground(Color.blue);
        this.jCheckBox98.setText("J");
        this.jCheckBox98.setEnabled(false);
        this.jCheckBox98.setName("OD7");
        this.jCheckBox98.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.118
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox99.setFont(new Font("Arial", 1, 12));
        this.jCheckBox99.setForeground(Color.blue);
        this.jCheckBox99.setText("V");
        this.jCheckBox99.setEnabled(false);
        this.jCheckBox99.setName("OD7");
        this.jCheckBox99.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.119
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox100.setFont(new Font("Arial", 1, 12));
        this.jCheckBox100.setForeground(Color.blue);
        this.jCheckBox100.setText("R");
        this.jCheckBox100.setEnabled(false);
        this.jCheckBox100.setName("OD7");
        this.jCheckBox100.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.120
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox101.setFont(new Font("Arial", 1, 12));
        this.jCheckBox101.setForeground(Color.blue);
        this.jCheckBox101.setText("Z");
        this.jCheckBox101.setEnabled(false);
        this.jCheckBox101.setName("OD7");
        this.jCheckBox101.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.121
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox102.setFont(new Font("Arial", 1, 12));
        this.jCheckBox102.setForeground(Color.blue);
        this.jCheckBox102.setText("K");
        this.jCheckBox102.setEnabled(false);
        this.jCheckBox102.setName("OD7");
        this.jCheckBox102.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.122
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox103.setFont(new Font("Arial", 1, 12));
        this.jCheckBox103.setForeground(Color.blue);
        this.jCheckBox103.setText("J");
        this.jCheckBox103.setEnabled(false);
        this.jCheckBox103.setName("OD8");
        this.jCheckBox103.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.123
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox104.setFont(new Font("Arial", 1, 12));
        this.jCheckBox104.setForeground(Color.blue);
        this.jCheckBox104.setText("R");
        this.jCheckBox104.setEnabled(false);
        this.jCheckBox104.setName("OD8");
        this.jCheckBox104.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.124
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox105.setFont(new Font("Arial", 1, 12));
        this.jCheckBox105.setForeground(Color.blue);
        this.jCheckBox105.setText("L");
        this.jCheckBox105.setEnabled(false);
        this.jCheckBox105.setName("OD8");
        this.jCheckBox105.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.125
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox106.setFont(new Font("Arial", 1, 12));
        this.jCheckBox106.setForeground(Color.blue);
        this.jCheckBox106.setText("H");
        this.jCheckBox106.setEnabled(false);
        this.jCheckBox106.setName("OD8");
        this.jCheckBox106.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.126
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox107.setFont(new Font("Arial", 1, 12));
        this.jCheckBox107.setForeground(Color.blue);
        this.jCheckBox107.setText("U");
        this.jCheckBox107.setEnabled(false);
        this.jCheckBox107.setName("OD8");
        this.jCheckBox107.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.127
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox108.setFont(new Font("Arial", 1, 12));
        this.jCheckBox108.setForeground(Color.blue);
        this.jCheckBox108.setText("E");
        this.jCheckBox108.setEnabled(false);
        this.jCheckBox108.setName("OD8");
        this.jCheckBox108.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.128
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox109.setFont(new Font("Arial", 1, 12));
        this.jCheckBox109.setForeground(Color.blue);
        this.jCheckBox109.setText("Z");
        this.jCheckBox109.setEnabled(false);
        this.jCheckBox109.setName("OD9");
        this.jCheckBox109.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.129
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox110.setFont(new Font("Arial", 1, 12));
        this.jCheckBox110.setForeground(Color.blue);
        this.jCheckBox110.setText("T");
        this.jCheckBox110.setEnabled(false);
        this.jCheckBox110.setName("OD9");
        this.jCheckBox110.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.130
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox111.setFont(new Font("Arial", 1, 12));
        this.jCheckBox111.setForeground(Color.blue);
        this.jCheckBox111.setText("N");
        this.jCheckBox111.setEnabled(false);
        this.jCheckBox111.setName("OD9");
        this.jCheckBox111.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.131
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox112.setFont(new Font("Arial", 1, 12));
        this.jCheckBox112.setForeground(Color.blue);
        this.jCheckBox112.setText("F");
        this.jCheckBox112.setEnabled(false);
        this.jCheckBox112.setName("OD9");
        this.jCheckBox112.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.132
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox113.setFont(new Font("Arial", 1, 12));
        this.jCheckBox113.setForeground(Color.blue);
        this.jCheckBox113.setText("K");
        this.jCheckBox113.setEnabled(false);
        this.jCheckBox113.setName("OD9");
        this.jCheckBox113.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.133
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox114.setFont(new Font("Arial", 1, 12));
        this.jCheckBox114.setForeground(Color.blue);
        this.jCheckBox114.setText("V");
        this.jCheckBox114.setEnabled(false);
        this.jCheckBox114.setName("OD9");
        this.jCheckBox114.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.134
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox115.setFont(new Font("Arial", 1, 12));
        this.jCheckBox115.setForeground(Color.blue);
        this.jCheckBox115.setText("U");
        this.jCheckBox115.setEnabled(false);
        this.jCheckBox115.setName("OD10");
        this.jCheckBox115.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.135
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox116.setFont(new Font("Arial", 1, 12));
        this.jCheckBox116.setForeground(Color.blue);
        this.jCheckBox116.setText("H");
        this.jCheckBox116.setEnabled(false);
        this.jCheckBox116.setName("OD10");
        this.jCheckBox116.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.136
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox117.setFont(new Font("Arial", 1, 12));
        this.jCheckBox117.setForeground(Color.blue);
        this.jCheckBox117.setText("A");
        this.jCheckBox117.setEnabled(false);
        this.jCheckBox117.setName("OD10");
        this.jCheckBox117.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.137
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox118.setFont(new Font("Arial", 1, 12));
        this.jCheckBox118.setForeground(Color.blue);
        this.jCheckBox118.setText("C");
        this.jCheckBox118.setEnabled(false);
        this.jCheckBox118.setName("OD10");
        this.jCheckBox118.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.138
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox119.setFont(new Font("Arial", 1, 12));
        this.jCheckBox119.setForeground(Color.blue);
        this.jCheckBox119.setText("R");
        this.jCheckBox119.setEnabled(false);
        this.jCheckBox119.setName("OD10");
        this.jCheckBox119.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.139
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        this.jCheckBox120.setFont(new Font("Arial", 1, 12));
        this.jCheckBox120.setForeground(Color.blue);
        this.jCheckBox120.setText("K");
        this.jCheckBox120.setEnabled(false);
        this.jCheckBox120.setName("OD10");
        this.jCheckBox120.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.140
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoODCheck(evt);
            }
        });
        GroupLayout JPODLayout = new GroupLayout(this.JPOD);
        this.JPOD.setLayout(JPODLayout);
        JPODLayout.setHorizontalGroup(JPODLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPODLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPODLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPODLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPODLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPODLayout.createSequentialGroup().addComponent(this.OD9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox109).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox110).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox111).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox112).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox113).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox114)).addGroup(JPODLayout.createSequentialGroup().addComponent(this.OD8).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox103).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox104).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox105).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox106).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox107).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox108)).addGroup(JPODLayout.createSequentialGroup().addComponent(this.OD7).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox97).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox98).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox99).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox100).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox101).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox102)).addGroup(JPODLayout.createSequentialGroup().addComponent(this.OD6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox91).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox92).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox93).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox94).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox95).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox96)).addGroup(JPODLayout.createSequentialGroup().addComponent(this.OD5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox85).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox86).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox87).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox88).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox89).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox90)).addGroup(JPODLayout.createSequentialGroup().addComponent(this.OD4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox79).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox80).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox81).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox82).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox83).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox84)).addGroup(JPODLayout.createSequentialGroup().addComponent(this.OD3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox73).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox74).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox75).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox76).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox77).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox78)).addGroup(JPODLayout.createSequentialGroup().addComponent(this.OD2).addGap(0, 0, 0).addComponent(this.jCheckBox67).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox68).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox69).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox70).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox71).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox72)).addGroup(JPODLayout.createSequentialGroup().addComponent(this.OD1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox61).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox62).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox63).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox64).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox65).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox66)))).addGroup(JPODLayout.createSequentialGroup().addComponent(this.OD10).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox115).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox116).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox117).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox118).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox119).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox120))).addGap(3, 3, 3)));
        JPODLayout.setVerticalGroup(JPODLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPODLayout.createSequentialGroup().addGroup(JPODLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.OD1).addComponent(this.jCheckBox61).addComponent(this.jCheckBox62).addComponent(this.jCheckBox63).addComponent(this.jCheckBox64).addComponent(this.jCheckBox65).addComponent(this.jCheckBox66)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPODLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.OD2).addComponent(this.jCheckBox67).addComponent(this.jCheckBox68).addComponent(this.jCheckBox69).addComponent(this.jCheckBox70).addComponent(this.jCheckBox71).addComponent(this.jCheckBox72)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPODLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.OD3).addComponent(this.jCheckBox73).addComponent(this.jCheckBox74).addComponent(this.jCheckBox75).addComponent(this.jCheckBox76).addComponent(this.jCheckBox77).addComponent(this.jCheckBox78)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPODLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.OD4).addComponent(this.jCheckBox79).addComponent(this.jCheckBox80).addComponent(this.jCheckBox81).addComponent(this.jCheckBox82).addComponent(this.jCheckBox83).addComponent(this.jCheckBox84)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPODLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.OD5).addComponent(this.jCheckBox85).addComponent(this.jCheckBox86).addComponent(this.jCheckBox87).addComponent(this.jCheckBox88).addComponent(this.jCheckBox89).addComponent(this.jCheckBox90)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPODLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.OD6).addComponent(this.jCheckBox91).addComponent(this.jCheckBox92).addComponent(this.jCheckBox93).addComponent(this.jCheckBox94).addComponent(this.jCheckBox95).addComponent(this.jCheckBox96)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPODLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.OD7).addComponent(this.jCheckBox97).addComponent(this.jCheckBox98).addComponent(this.jCheckBox99).addComponent(this.jCheckBox100).addComponent(this.jCheckBox101).addComponent(this.jCheckBox102)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPODLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.OD8).addComponent(this.jCheckBox103).addComponent(this.jCheckBox104).addComponent(this.jCheckBox105).addComponent(this.jCheckBox106).addComponent(this.jCheckBox107).addComponent(this.jCheckBox108)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPODLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.OD9).addComponent(this.jCheckBox109).addComponent(this.jCheckBox110).addComponent(this.jCheckBox111).addComponent(this.jCheckBox112).addComponent(this.jCheckBox113).addComponent(this.jCheckBox114)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPODLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.OD10).addComponent(this.jCheckBox115).addComponent(this.jCheckBox116).addComponent(this.jCheckBox117).addComponent(this.jCheckBox118).addComponent(this.jCheckBox119).addComponent(this.jCheckBox120))));
        this.JPOI.setBorder(BorderFactory.createTitledBorder((Border) null, "Ojo Izquierdo", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JPOI.setName("OI");
        this.ojoIzquierdo.add(this.OI1);
        this.OI1.setFont(new Font("Arial", 1, 12));
        this.OI1.setText("1");
        this.OI1.setName("20/100");
        this.OI1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.141
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.OI1ActionPerformed(evt);
            }
        });
        this.ojoIzquierdo.add(this.OI2);
        this.OI2.setFont(new Font("Arial", 1, 12));
        this.OI2.setText("2");
        this.OI2.setName("20/85");
        this.OI2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.142
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.OI2ActionPerformed(evt);
            }
        });
        this.ojoIzquierdo.add(this.OI3);
        this.OI3.setFont(new Font("Arial", 1, 12));
        this.OI3.setText("3");
        this.OI3.setName("20/70");
        this.OI3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.143
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.OI3ActionPerformed(evt);
            }
        });
        this.ojoIzquierdo.add(this.OI4);
        this.OI4.setFont(new Font("Arial", 1, 12));
        this.OI4.setText("4");
        this.OI4.setName("20/50");
        this.OI4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.144
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.OI4ActionPerformed(evt);
            }
        });
        this.ojoIzquierdo.add(this.OI5);
        this.OI5.setFont(new Font("Arial", 1, 12));
        this.OI5.setText("5");
        this.OI5.setName("20/40");
        this.OI5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.145
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.OI5ActionPerformed(evt);
            }
        });
        this.ojoIzquierdo.add(this.OI6);
        this.OI6.setFont(new Font("Arial", 1, 12));
        this.OI6.setText("6");
        this.OI6.setName("20/30");
        this.OI6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.146
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.OI6ActionPerformed(evt);
            }
        });
        this.ojoIzquierdo.add(this.OI7);
        this.OI7.setFont(new Font("Arial", 1, 12));
        this.OI7.setText("7");
        this.OI7.setName("20/25");
        this.OI7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.147
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.OI7ActionPerformed(evt);
            }
        });
        this.ojoIzquierdo.add(this.OI8);
        this.OI8.setFont(new Font("Arial", 1, 12));
        this.OI8.setText("8");
        this.OI8.setName("20/20");
        this.OI8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.148
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.OI8ActionPerformed(evt);
            }
        });
        this.ojoIzquierdo.add(this.OI9);
        this.OI9.setFont(new Font("Arial", 1, 12));
        this.OI9.setText("9");
        this.OI9.setName("20/15");
        this.OI9.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.149
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.OI9ActionPerformed(evt);
            }
        });
        this.ojoIzquierdo.add(this.OI10);
        this.OI10.setFont(new Font("Arial", 1, 12));
        this.OI10.setText("10");
        this.OI10.setName("20/10");
        this.OI10.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.150
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.OI10ActionPerformed(evt);
            }
        });
        this.jCheckBox121.setFont(new Font("Arial", 1, 12));
        this.jCheckBox121.setForeground(Color.blue);
        this.jCheckBox121.setText("U");
        this.jCheckBox121.setEnabled(false);
        this.jCheckBox121.setName("OI1");
        this.jCheckBox121.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.151
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox122.setFont(new Font("Arial", 1, 12));
        this.jCheckBox122.setForeground(Color.blue);
        this.jCheckBox122.setText("Z");
        this.jCheckBox122.setEnabled(false);
        this.jCheckBox122.setName("OI1");
        this.jCheckBox122.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.152
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox123.setFont(new Font("Arial", 1, 12));
        this.jCheckBox123.setForeground(Color.blue);
        this.jCheckBox123.setText("T");
        this.jCheckBox123.setEnabled(false);
        this.jCheckBox123.setName("OI1");
        this.jCheckBox123.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.153
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox124.setFont(new Font("Arial", 1, 12));
        this.jCheckBox124.setForeground(Color.blue);
        this.jCheckBox124.setText("L");
        this.jCheckBox124.setEnabled(false);
        this.jCheckBox124.setName("OI1");
        this.jCheckBox124.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.154
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox125.setFont(new Font("Arial", 1, 12));
        this.jCheckBox125.setForeground(Color.blue);
        this.jCheckBox125.setText("E");
        this.jCheckBox125.setEnabled(false);
        this.jCheckBox125.setName("OI1");
        this.jCheckBox125.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.155
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox126.setFont(new Font("Arial", 1, 12));
        this.jCheckBox126.setForeground(Color.blue);
        this.jCheckBox126.setText("K");
        this.jCheckBox126.setEnabled(false);
        this.jCheckBox126.setName("OI1");
        this.jCheckBox126.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.156
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox127.setFont(new Font("Arial", 1, 12));
        this.jCheckBox127.setForeground(Color.blue);
        this.jCheckBox127.setText("P");
        this.jCheckBox127.setEnabled(false);
        this.jCheckBox127.setName("OI2");
        this.jCheckBox127.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.157
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox128.setFont(new Font("Arial", 1, 12));
        this.jCheckBox128.setForeground(Color.blue);
        this.jCheckBox128.setText("F");
        this.jCheckBox128.setEnabled(false);
        this.jCheckBox128.setName("OI2");
        this.jCheckBox128.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.158
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox129.setFont(new Font("Arial", 1, 12));
        this.jCheckBox129.setForeground(Color.blue);
        this.jCheckBox129.setText("Z");
        this.jCheckBox129.setEnabled(false);
        this.jCheckBox129.setName("OI2");
        this.jCheckBox129.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.159
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox130.setFont(new Font("Arial", 1, 12));
        this.jCheckBox130.setForeground(Color.blue);
        this.jCheckBox130.setText("H");
        this.jCheckBox130.setEnabled(false);
        this.jCheckBox130.setName("OI2");
        this.jCheckBox130.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.160
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox131.setFont(new Font("Arial", 1, 12));
        this.jCheckBox131.setForeground(Color.blue);
        this.jCheckBox131.setText("K");
        this.jCheckBox131.setEnabled(false);
        this.jCheckBox131.setName("OI2");
        this.jCheckBox131.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.161
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox132.setFont(new Font("Arial", 1, 12));
        this.jCheckBox132.setForeground(Color.blue);
        this.jCheckBox132.setText("R");
        this.jCheckBox132.setEnabled(false);
        this.jCheckBox132.setName("OI2");
        this.jCheckBox132.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.162
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox133.setFont(new Font("Arial", 1, 12));
        this.jCheckBox133.setForeground(Color.blue);
        this.jCheckBox133.setText("K");
        this.jCheckBox133.setEnabled(false);
        this.jCheckBox133.setName("OI3");
        this.jCheckBox133.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.163
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox134.setFont(new Font("Arial", 1, 12));
        this.jCheckBox134.setForeground(Color.blue);
        this.jCheckBox134.setText("R");
        this.jCheckBox134.setEnabled(false);
        this.jCheckBox134.setName("OI3");
        this.jCheckBox134.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.164
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox135.setFont(new Font("Arial", 1, 12));
        this.jCheckBox135.setForeground(Color.blue);
        this.jCheckBox135.setText("U");
        this.jCheckBox135.setEnabled(false);
        this.jCheckBox135.setName("OI3");
        this.jCheckBox135.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.165
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox136.setFont(new Font("Arial", 1, 12));
        this.jCheckBox136.setForeground(Color.blue);
        this.jCheckBox136.setText("C");
        this.jCheckBox136.setEnabled(false);
        this.jCheckBox136.setName("OI3");
        this.jCheckBox136.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.166
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox137.setFont(new Font("Arial", 1, 12));
        this.jCheckBox137.setForeground(Color.blue);
        this.jCheckBox137.setText("T");
        this.jCheckBox137.setEnabled(false);
        this.jCheckBox137.setName("OI3");
        this.jCheckBox137.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.167
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox138.setFont(new Font("Arial", 1, 12));
        this.jCheckBox138.setForeground(Color.blue);
        this.jCheckBox138.setText("N");
        this.jCheckBox138.setEnabled(false);
        this.jCheckBox138.setName("OI3");
        this.jCheckBox138.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.168
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox139.setFont(new Font("Arial", 1, 12));
        this.jCheckBox139.setForeground(Color.blue);
        this.jCheckBox139.setText("Z");
        this.jCheckBox139.setEnabled(false);
        this.jCheckBox139.setName("OI4");
        this.jCheckBox139.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.169
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox140.setFont(new Font("Arial", 1, 12));
        this.jCheckBox140.setForeground(Color.blue);
        this.jCheckBox140.setText("N");
        this.jCheckBox140.setEnabled(false);
        this.jCheckBox140.setName("OI4");
        this.jCheckBox140.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.170
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox141.setFont(new Font("Arial", 1, 12));
        this.jCheckBox141.setForeground(Color.blue);
        this.jCheckBox141.setText("V");
        this.jCheckBox141.setEnabled(false);
        this.jCheckBox141.setName("OI4");
        this.jCheckBox141.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.171
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox142.setFont(new Font("Arial", 1, 12));
        this.jCheckBox142.setForeground(Color.blue);
        this.jCheckBox142.setText("K");
        this.jCheckBox142.setEnabled(false);
        this.jCheckBox142.setName("OI4");
        this.jCheckBox142.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.172
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox143.setFont(new Font("Arial", 1, 12));
        this.jCheckBox143.setForeground(Color.blue);
        this.jCheckBox143.setText("C");
        this.jCheckBox143.setEnabled(false);
        this.jCheckBox143.setName("OI4");
        this.jCheckBox143.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.173
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox144.setFont(new Font("Arial", 1, 12));
        this.jCheckBox144.setForeground(Color.blue);
        this.jCheckBox144.setText("U");
        this.jCheckBox144.setEnabled(false);
        this.jCheckBox144.setName("OI4");
        this.jCheckBox144.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.174
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox145.setFont(new Font("Arial", 1, 12));
        this.jCheckBox145.setForeground(Color.blue);
        this.jCheckBox145.setText("R");
        this.jCheckBox145.setEnabled(false);
        this.jCheckBox145.setName("OI5");
        this.jCheckBox145.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.175
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox146.setFont(new Font("Arial", 1, 12));
        this.jCheckBox146.setForeground(Color.blue);
        this.jCheckBox146.setText("P");
        this.jCheckBox146.setEnabled(false);
        this.jCheckBox146.setName("OI5");
        this.jCheckBox146.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.176
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox147.setFont(new Font("Arial", 1, 12));
        this.jCheckBox147.setForeground(Color.blue);
        this.jCheckBox147.setText("L");
        this.jCheckBox147.setEnabled(false);
        this.jCheckBox147.setName("OI5");
        this.jCheckBox147.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.177
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox148.setFont(new Font("Arial", 1, 12));
        this.jCheckBox148.setForeground(Color.blue);
        this.jCheckBox148.setText("V");
        this.jCheckBox148.setEnabled(false);
        this.jCheckBox148.setName("OI5");
        this.jCheckBox148.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.178
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox149.setFont(new Font("Arial", 1, 12));
        this.jCheckBox149.setForeground(Color.blue);
        this.jCheckBox149.setText("F");
        this.jCheckBox149.setEnabled(false);
        this.jCheckBox149.setName("OI5");
        this.jCheckBox149.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.179
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox150.setFont(new Font("Arial", 1, 12));
        this.jCheckBox150.setForeground(Color.blue);
        this.jCheckBox150.setText("T");
        this.jCheckBox150.setEnabled(false);
        this.jCheckBox150.setName("OI5");
        this.jCheckBox150.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.180
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox151.setFont(new Font("Arial", 1, 12));
        this.jCheckBox151.setForeground(Color.blue);
        this.jCheckBox151.setText("C");
        this.jCheckBox151.setEnabled(false);
        this.jCheckBox151.setName("OI6");
        this.jCheckBox151.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.181
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox152.setFont(new Font("Arial", 1, 12));
        this.jCheckBox152.setForeground(Color.blue);
        this.jCheckBox152.setText("H");
        this.jCheckBox152.setEnabled(false);
        this.jCheckBox152.setName("OI6");
        this.jCheckBox152.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.182
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox153.setFont(new Font("Arial", 1, 12));
        this.jCheckBox153.setForeground(Color.blue);
        this.jCheckBox153.setText("A");
        this.jCheckBox153.setEnabled(false);
        this.jCheckBox153.setName("OI6");
        this.jCheckBox153.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.183
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox154.setFont(new Font("Arial", 1, 12));
        this.jCheckBox154.setForeground(Color.blue);
        this.jCheckBox154.setText("P");
        this.jCheckBox154.setEnabled(false);
        this.jCheckBox154.setName("OI6");
        this.jCheckBox154.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.184
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox155.setFont(new Font("Arial", 1, 12));
        this.jCheckBox155.setForeground(Color.blue);
        this.jCheckBox155.setText("V");
        this.jCheckBox155.setEnabled(false);
        this.jCheckBox155.setName("OI6");
        this.jCheckBox155.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.185
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox156.setFont(new Font("Arial", 1, 12));
        this.jCheckBox156.setForeground(Color.blue);
        this.jCheckBox156.setText("E");
        this.jCheckBox156.setEnabled(false);
        this.jCheckBox156.setName("OI6");
        this.jCheckBox156.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.186
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox157.setFont(new Font("Arial", 1, 12));
        this.jCheckBox157.setForeground(Color.blue);
        this.jCheckBox157.setText("J");
        this.jCheckBox157.setEnabled(false);
        this.jCheckBox157.setName("OI7");
        this.jCheckBox157.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.187
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox158.setFont(new Font("Arial", 1, 12));
        this.jCheckBox158.setForeground(Color.blue);
        this.jCheckBox158.setText("K");
        this.jCheckBox158.setEnabled(false);
        this.jCheckBox158.setName("OI7");
        this.jCheckBox158.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.188
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox159.setFont(new Font("Arial", 1, 12));
        this.jCheckBox159.setForeground(Color.blue);
        this.jCheckBox159.setText("N");
        this.jCheckBox159.setEnabled(false);
        this.jCheckBox159.setName("OI7");
        this.jCheckBox159.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.189
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox160.setFont(new Font("Arial", 1, 12));
        this.jCheckBox160.setForeground(Color.blue);
        this.jCheckBox160.setText("T");
        this.jCheckBox160.setEnabled(false);
        this.jCheckBox160.setName("OI7");
        this.jCheckBox160.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.190
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox161.setFont(new Font("Arial", 1, 12));
        this.jCheckBox161.setForeground(Color.blue);
        this.jCheckBox161.setText("U");
        this.jCheckBox161.setEnabled(false);
        this.jCheckBox161.setName("OI7");
        this.jCheckBox161.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.191
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox162.setFont(new Font("Arial", 1, 12));
        this.jCheckBox162.setForeground(Color.blue);
        this.jCheckBox162.setText("P");
        this.jCheckBox162.setEnabled(false);
        this.jCheckBox162.setName("OI7");
        this.jCheckBox162.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.192
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox163.setFont(new Font("Arial", 1, 12));
        this.jCheckBox163.setForeground(Color.blue);
        this.jCheckBox163.setText("F");
        this.jCheckBox163.setEnabled(false);
        this.jCheckBox163.setName("OI8");
        this.jCheckBox163.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.193
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox164.setFont(new Font("Arial", 1, 12));
        this.jCheckBox164.setForeground(Color.blue);
        this.jCheckBox164.setText("V");
        this.jCheckBox164.setEnabled(false);
        this.jCheckBox164.setName("OI8");
        this.jCheckBox164.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.194
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox165.setFont(new Font("Arial", 1, 12));
        this.jCheckBox165.setForeground(Color.blue);
        this.jCheckBox165.setText("T");
        this.jCheckBox165.setEnabled(false);
        this.jCheckBox165.setName("OI8");
        this.jCheckBox165.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.195
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox166.setFont(new Font("Arial", 1, 12));
        this.jCheckBox166.setForeground(Color.blue);
        this.jCheckBox166.setText("K");
        this.jCheckBox166.setEnabled(false);
        this.jCheckBox166.setName("OI8");
        this.jCheckBox166.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.196
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox167.setFont(new Font("Arial", 1, 12));
        this.jCheckBox167.setForeground(Color.blue);
        this.jCheckBox167.setText("Z");
        this.jCheckBox167.setEnabled(false);
        this.jCheckBox167.setName("OI8");
        this.jCheckBox167.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.197
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox168.setFont(new Font("Arial", 1, 12));
        this.jCheckBox168.setForeground(Color.blue);
        this.jCheckBox168.setText("A");
        this.jCheckBox168.setEnabled(false);
        this.jCheckBox168.setName("OI8");
        this.jCheckBox168.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.198
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox169.setFont(new Font("Arial", 1, 12));
        this.jCheckBox169.setForeground(Color.blue);
        this.jCheckBox169.setText("T");
        this.jCheckBox169.setEnabled(false);
        this.jCheckBox169.setName("OI9");
        this.jCheckBox169.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.199
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox170.setFont(new Font("Arial", 1, 12));
        this.jCheckBox170.setForeground(Color.blue);
        this.jCheckBox170.setText("U");
        this.jCheckBox170.setEnabled(false);
        this.jCheckBox170.setName("OI9");
        this.jCheckBox170.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.200
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox171.setFont(new Font("Arial", 1, 12));
        this.jCheckBox171.setForeground(Color.blue);
        this.jCheckBox171.setText("J");
        this.jCheckBox171.setEnabled(false);
        this.jCheckBox171.setName("OI9");
        this.jCheckBox171.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.201
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox172.setFont(new Font("Arial", 1, 12));
        this.jCheckBox172.setForeground(Color.blue);
        this.jCheckBox172.setText("Z");
        this.jCheckBox172.setEnabled(false);
        this.jCheckBox172.setName("OI9");
        this.jCheckBox172.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.202
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox173.setFont(new Font("Arial", 1, 12));
        this.jCheckBox173.setForeground(Color.blue);
        this.jCheckBox173.setText("F");
        this.jCheckBox173.setEnabled(false);
        this.jCheckBox173.setName("OI9");
        this.jCheckBox173.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.203
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox174.setFont(new Font("Arial", 1, 12));
        this.jCheckBox174.setForeground(Color.blue);
        this.jCheckBox174.setText("H");
        this.jCheckBox174.setEnabled(false);
        this.jCheckBox174.setName("OI9");
        this.jCheckBox174.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.204
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox175.setFont(new Font("Arial", 1, 12));
        this.jCheckBox175.setForeground(Color.blue);
        this.jCheckBox175.setText("N");
        this.jCheckBox175.setEnabled(false);
        this.jCheckBox175.setName("OI10");
        this.jCheckBox175.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.205
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox176.setFont(new Font("Arial", 1, 12));
        this.jCheckBox176.setForeground(Color.blue);
        this.jCheckBox176.setText("C");
        this.jCheckBox176.setEnabled(false);
        this.jCheckBox176.setName("OI10");
        this.jCheckBox176.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.206
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox177.setFont(new Font("Arial", 1, 12));
        this.jCheckBox177.setForeground(Color.blue);
        this.jCheckBox177.setText("H");
        this.jCheckBox177.setEnabled(false);
        this.jCheckBox177.setName("OI10");
        this.jCheckBox177.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.207
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox178.setFont(new Font("Arial", 1, 12));
        this.jCheckBox178.setForeground(Color.blue);
        this.jCheckBox178.setText("J");
        this.jCheckBox178.setEnabled(false);
        this.jCheckBox178.setName("OI10");
        this.jCheckBox178.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.208
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox179.setFont(new Font("Arial", 1, 12));
        this.jCheckBox179.setForeground(Color.blue);
        this.jCheckBox179.setText("R");
        this.jCheckBox179.setEnabled(false);
        this.jCheckBox179.setName("OI10");
        this.jCheckBox179.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.209
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        this.jCheckBox180.setFont(new Font("Arial", 1, 12));
        this.jCheckBox180.setForeground(Color.blue);
        this.jCheckBox180.setText("A");
        this.jCheckBox180.setEnabled(false);
        this.jCheckBox180.setName("OI10");
        this.jCheckBox180.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaDistancias.210
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaDistancias.this.eventCalculaOptotipoOICheck(evt);
            }
        });
        GroupLayout JPOILayout = new GroupLayout(this.JPOI);
        this.JPOI.setLayout(JPOILayout);
        JPOILayout.setHorizontalGroup(JPOILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPOILayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPOILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOILayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPOILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOILayout.createSequentialGroup().addComponent(this.OI9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox169).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox170).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox171).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox172).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox173).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox174)).addGroup(JPOILayout.createSequentialGroup().addComponent(this.OI8).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox163).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox164).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox165).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox166).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox167).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox168)).addGroup(JPOILayout.createSequentialGroup().addComponent(this.OI7).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox157).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox158).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox159).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox160).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox161).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox162)).addGroup(JPOILayout.createSequentialGroup().addComponent(this.OI6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox151).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox152).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox153).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox154).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox155).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox156)).addGroup(JPOILayout.createSequentialGroup().addComponent(this.OI5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox145).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox146).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox147).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox148).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox149).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox150)).addGroup(JPOILayout.createSequentialGroup().addComponent(this.OI4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox139).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox140).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox141).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox142).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox143).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox144)).addGroup(JPOILayout.createSequentialGroup().addComponent(this.OI3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox133).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox134).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox135).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox136).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox137).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox138)).addGroup(JPOILayout.createSequentialGroup().addComponent(this.OI2).addGap(0, 0, 0).addComponent(this.jCheckBox127).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox128).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox129).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox130).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox131).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox132)).addGroup(JPOILayout.createSequentialGroup().addComponent(this.OI1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox121).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox122).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox123).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox124).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox125).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox126)))).addGroup(JPOILayout.createSequentialGroup().addComponent(this.OI10).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox175).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox176).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox177).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox178).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox179).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox180))).addGap(3, 3, 3)));
        JPOILayout.setVerticalGroup(JPOILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOILayout.createSequentialGroup().addGroup(JPOILayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.OI1).addComponent(this.jCheckBox121).addComponent(this.jCheckBox122).addComponent(this.jCheckBox123).addComponent(this.jCheckBox124).addComponent(this.jCheckBox125).addComponent(this.jCheckBox126)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPOILayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.OI2).addComponent(this.jCheckBox127).addComponent(this.jCheckBox128).addComponent(this.jCheckBox129).addComponent(this.jCheckBox130).addComponent(this.jCheckBox131).addComponent(this.jCheckBox132)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPOILayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.OI3).addComponent(this.jCheckBox133).addComponent(this.jCheckBox134).addComponent(this.jCheckBox135).addComponent(this.jCheckBox136).addComponent(this.jCheckBox137).addComponent(this.jCheckBox138)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPOILayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.OI4).addComponent(this.jCheckBox139).addComponent(this.jCheckBox140).addComponent(this.jCheckBox141).addComponent(this.jCheckBox142).addComponent(this.jCheckBox143).addComponent(this.jCheckBox144)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPOILayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.OI5).addComponent(this.jCheckBox145).addComponent(this.jCheckBox146).addComponent(this.jCheckBox147).addComponent(this.jCheckBox148).addComponent(this.jCheckBox149).addComponent(this.jCheckBox150)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPOILayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.OI6).addComponent(this.jCheckBox151).addComponent(this.jCheckBox152).addComponent(this.jCheckBox153).addComponent(this.jCheckBox154).addComponent(this.jCheckBox155).addComponent(this.jCheckBox156)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPOILayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.OI7).addComponent(this.jCheckBox157).addComponent(this.jCheckBox158).addComponent(this.jCheckBox159).addComponent(this.jCheckBox160).addComponent(this.jCheckBox161).addComponent(this.jCheckBox162)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPOILayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.OI8).addComponent(this.jCheckBox163).addComponent(this.jCheckBox164).addComponent(this.jCheckBox165).addComponent(this.jCheckBox166).addComponent(this.jCheckBox167).addComponent(this.jCheckBox168)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPOILayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.OI9).addComponent(this.jCheckBox169).addComponent(this.jCheckBox170).addComponent(this.jCheckBox171).addComponent(this.jCheckBox172).addComponent(this.jCheckBox173).addComponent(this.jCheckBox174)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPOILayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.OI10).addComponent(this.jCheckBox175).addComponent(this.jCheckBox176).addComponent(this.jCheckBox177).addComponent(this.jCheckBox178).addComponent(this.jCheckBox179).addComponent(this.jCheckBox180))));
        this.JLLineaAO.setFont(new Font("Arial", 1, 14));
        this.JLLineaAO.setForeground(Color.red);
        this.JLLineaAO.setHorizontalAlignment(0);
        this.JLLineaAO.setText("0");
        this.JLLineaAO.setBorder(BorderFactory.createTitledBorder((Border) null, "Línea", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JLOptotipoAO.setFont(new Font("Arial", 1, 14));
        this.JLOptotipoAO.setForeground(Color.red);
        this.JLOptotipoAO.setHorizontalAlignment(0);
        this.JLOptotipoAO.setText("0");
        this.JLOptotipoAO.setBorder(BorderFactory.createTitledBorder((Border) null, "Optotipos", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JLNivelAO.setFont(new Font("Arial", 1, 14));
        this.JLNivelAO.setForeground(Color.red);
        this.JLNivelAO.setHorizontalAlignment(0);
        this.JLNivelAO.setBorder(BorderFactory.createTitledBorder((Border) null, "Nivel AV", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JLLineaOD.setFont(new Font("Arial", 1, 14));
        this.JLLineaOD.setForeground(Color.red);
        this.JLLineaOD.setHorizontalAlignment(0);
        this.JLLineaOD.setText("0");
        this.JLLineaOD.setBorder(BorderFactory.createTitledBorder((Border) null, "Línea", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JLOptotiposOD.setFont(new Font("Arial", 1, 14));
        this.JLOptotiposOD.setForeground(Color.red);
        this.JLOptotiposOD.setHorizontalAlignment(0);
        this.JLOptotiposOD.setText("0");
        this.JLOptotiposOD.setBorder(BorderFactory.createTitledBorder((Border) null, "Optotipos", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JLNivelOD.setFont(new Font("Arial", 1, 14));
        this.JLNivelOD.setForeground(Color.red);
        this.JLNivelOD.setHorizontalAlignment(0);
        this.JLNivelOD.setBorder(BorderFactory.createTitledBorder((Border) null, "Nivel AV", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JLLineaOI.setFont(new Font("Arial", 1, 14));
        this.JLLineaOI.setForeground(Color.red);
        this.JLLineaOI.setHorizontalAlignment(0);
        this.JLLineaOI.setText("0");
        this.JLLineaOI.setBorder(BorderFactory.createTitledBorder((Border) null, "Línea", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JLOptotiposOI.setFont(new Font("Arial", 1, 14));
        this.JLOptotiposOI.setForeground(Color.red);
        this.JLOptotiposOI.setHorizontalAlignment(0);
        this.JLOptotiposOI.setText("0");
        this.JLOptotiposOI.setBorder(BorderFactory.createTitledBorder((Border) null, "Optotipos", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JLNivelOI.setFont(new Font("Arial", 1, 14));
        this.JLNivelOI.setForeground(Color.red);
        this.JLNivelOI.setHorizontalAlignment(0);
        this.JLNivelOI.setBorder(BorderFactory.createTitledBorder((Border) null, "Nivel AV", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBClaAO.setFont(new Font("Arial", 1, 12));
        this.JCBClaAO.setModel(new DefaultComboBoxModel(new String[]{" ", "NORMAL", "ANORMAL"}));
        this.JCBClaAO.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBClaOD.setFont(new Font("Arial", 1, 12));
        this.JCBClaOD.setModel(new DefaultComboBoxModel(new String[]{" ", "NORMAL", "ANORMAL"}));
        this.JCBClaOD.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBClaOI.setFont(new Font("Arial", 1, 12));
        this.JCBClaOI.setModel(new DefaultComboBoxModel(new String[]{" ", "NORMAL", "ANORMAL"}));
        this.JCBClaOI.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPAO, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JLLineaAO, -2, 89, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLOptotipoAO, -2, 92, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLNivelAO, -1, -1, 32767))).addComponent(this.JCBClaAO, -2, 289, -2)).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPOD, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JLLineaOD, -2, 68, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLOptotiposOD, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLNivelOD, -2, 82, -2)).addComponent(this.JCBClaOD, 0, -1, 32767)).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPOI, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JLLineaOI, -2, 68, -2).addGap(3, 3, 3).addComponent(this.JLOptotiposOI, -2, 87, -2).addGap(3, 3, 3).addComponent(this.JLNivelOI, -2, 91, -2)).addComponent(this.JCBClaOI, 0, -1, 32767)).addGap(3, 3, 3)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPOI, -2, -1, -2).addComponent(this.JPOD, -2, -1, -2).addComponent(this.JPAO, -2, -1, -2)).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLLineaAO, -1, -1, 32767).addComponent(this.JLOptotipoAO, -1, 70, 32767).addComponent(this.JLNivelAO, GroupLayout.Alignment.TRAILING, -1, 70, 32767).addComponent(this.JLLineaOD, -1, -1, 32767).addComponent(this.JLOptotiposOD, -1, 70, 32767).addComponent(this.JLNivelOD, GroupLayout.Alignment.TRAILING, -1, 70, 32767).addComponent(this.JLLineaOI, -1, -1, 32767).addComponent(this.JLOptotiposOI, -1, 70, 32767).addComponent(this.JLNivelOI, GroupLayout.Alignment.TRAILING, -1, 70, 32767)).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBClaAO, -2, 58, -2).addComponent(this.JCBClaOD, -2, 58, -2).addComponent(this.JCBClaOI, -2, 58, -2)).addGap(5, 5, 5)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AO1ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPAO, this.AO1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AO2ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPAO, this.AO2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AO3ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPAO, this.AO3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AO4ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPAO, this.AO4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AO5ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPAO, this.AO5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AO6ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPAO, this.AO6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AO7ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPAO, this.AO7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AO8ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPAO, this.AO8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AO9ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPAO, this.AO9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AO10ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPAO, this.AO10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OD1ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPOD, this.OD1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OD2ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPOD, this.OD2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OD3ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPOD, this.OD3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OD4ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPOD, this.OD4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OD5ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPOD, this.OD5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OD6ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPOD, this.OD6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OD7ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPOD, this.OD7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OD8ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPOD, this.OD8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OD9ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPOD, this.OD9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OD10ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPOD, this.OD10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OI1ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPOI, this.OI1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OI2ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPOI, this.OI2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OI3ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPOI, this.OI3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OI4ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPOI, this.OI4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OI5ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPOI, this.OI5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OI6ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPOI, this.OI6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OI7ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPOI, this.OI7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OI8ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPOI, this.OI8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OI9ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPOI, this.OI9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OI10ActionPerformed(ActionEvent evt) {
        mQuitaDeshabilitaCheckPanel(this.JPOI, this.OI10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eventCalculaOptotipoCheck(ActionEvent evt) {
        JCheckBox xc = (JCheckBox) evt.getSource();
        if (xc.isSelected()) {
            this.xOptAO++;
            this.AO.add(evt.getActionCommand());
        } else {
            this.xOptAO--;
            for (int i = this.AO.size() - 1; i > 0; i--) {
                if (this.AO.get(i).equals(evt.getActionCommand())) {
                    this.AO.remove(i);
                }
            }
        }
        this.JLOptotipoAO.setText("" + this.xOptAO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eventCalculaOptotipoODCheck(ActionEvent evt) {
        JCheckBox xc = (JCheckBox) evt.getSource();
        if (xc.isSelected()) {
            this.xOptOD++;
            this.OD.add(evt.getActionCommand());
        } else {
            this.xOptOD--;
            for (int i = this.OD.size() - 1; i > 0; i--) {
                if (this.OD.get(i).equals(evt.getActionCommand())) {
                    this.OD.remove(i);
                }
            }
        }
        this.JLOptotiposOD.setText("" + this.xOptOD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eventCalculaOptotipoOICheck(ActionEvent evt) {
        JCheckBox xc = (JCheckBox) evt.getSource();
        if (xc.isSelected()) {
            this.xOptOI++;
            this.OI.add(evt.getActionCommand());
        } else {
            this.xOptOI--;
            for (int i = this.OI.size() - 1; i > 0; i--) {
                if (this.OI.get(i).equals(evt.getActionCommand())) {
                    this.OI.remove(i);
                }
            }
        }
        this.JLOptotiposOI.setText("" + this.xOptOI);
    }

    private void mQuitaDeshabilitaCheckPanel(JPanel xpanel, JRadioButton xbutton) {
        switch (xpanel.getName()) {
            case "AO":
                this.xOptAO = 0;
                this.JLLineaAO.setText(xbutton.getText());
                this.JLNivelAO.setText(xbutton.getName());
                this.JLOptotipoAO.setText("0");
                this.AO = new ArrayList<>();
                break;
            case "OD":
                this.xOptOD = 0;
                this.JLLineaOD.setText(xbutton.getText());
                this.JLNivelOD.setText(xbutton.getName());
                this.JLOptotiposOD.setText("0");
                this.OD = new ArrayList<>();
                break;
            case "OI":
                this.xOptOI = 0;
                this.JLLineaOI.setText(xbutton.getText());
                this.JLNivelOI.setText(xbutton.getName());
                this.JLOptotiposOI.setText("0");
                this.OI = new ArrayList<>();
                break;
        }
        int cont = 0;
        for (int x = 0; x < xpanel.getComponentCount(); x++) {
            if (xpanel.getComponent(x).getClass().getName().equals("javax.swing.JCheckBox")) {
                JCheckBox xch = xpanel.getComponent(x);
                xch.setSelected(false);
                xch.setEnabled(false);
            }
        }
        for (int x2 = 0; x2 < xpanel.getComponentCount(); x2++) {
            if (xpanel.getComponent(x2).getClass().getName().equals("javax.swing.JCheckBox")) {
                JCheckBox xch2 = xpanel.getComponent(x2);
                StringBuilder sb = new StringBuilder();
                String selec = sb.append(xpanel.getName()).append(xbutton.getText()).toString();
                if (xch2.getName().equals(selec)) {
                    cont++;
                    xch2.setEnabled(true);
                    if (cont == 6) {
                        return;
                    }
                } else {
                    continue;
                }
            }
        }
    }
}
