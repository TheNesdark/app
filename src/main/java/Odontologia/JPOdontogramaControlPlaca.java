package Odontologia;

import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JPOdontogramaControlPlaca.class */
public class JPOdontogramaControlPlaca extends JPanel {
    private ConsultasMySQL xct = new ConsultasMySQL();
    private JLabel JL129;
    private JLabel JL130;
    private JLabel JL131;
    private JLabel JL132;
    private JLabel JL133;
    private JLabel JL134;
    private JLabel JL135;
    private JLabel JL136;
    private JLabel JL137;
    private JLabel JL138;
    private JLabel JL139;
    private JLabel JL140;
    private JLabel JL141;
    private JLabel JL142;
    private JLabel JL143;
    private JLabel JL144;
    private JLabel JL145;
    private JLabel JL146;
    private JLabel JL147;
    private JLabel JL148;
    private JLabel JL149;
    private JLabel JL150;
    private JLabel JL151;
    private JLabel JL152;
    private JLabel JL153;
    private JLabel JL154;
    private JLabel JL155;
    private JLabel JL156;
    private JLabel JL157;
    private JLabel JL158;
    private JLabel JL159;
    private JLabel JL160;
    private JLabel JL161;
    private JLabel JL162;
    private JLabel JL163;
    private JLabel JL164;
    private JLabel JL165;
    private JLabel JL166;
    private JLabel JL167;
    private JLabel JL168;
    private JLabel JL169;
    private JLabel JL170;
    private JLabel JL171;
    private JLabel JL172;
    private JLabel JL173;
    private JLabel JL174;
    private JLabel JL175;
    private JLabel JL176;
    private JLabel JL177;
    private JLabel JL178;
    private JLabel JL179;
    private JLabel JL180;
    private JLabel JL181;
    private JLabel JL182;
    private JLabel JL183;
    private JLabel JL184;
    private JLabel JL185;
    private JLabel JL186;
    private JLabel JL187;
    private JLabel JL188;
    private JLabel JL189;
    private JLabel JL190;
    private JLabel JL191;
    private JLabel JL192;
    private JLabel JL193;
    private JLabel JL194;
    private JLabel JL195;
    private JLabel JL196;
    private JLabel JL197;
    private JLabel JL198;
    private JLabel JL199;
    private JLabel JL200;
    private JLabel JL201;
    private JLabel JL202;
    private JLabel JL203;
    private JLabel JL204;
    private JLabel JL205;
    private JLabel JL206;
    private JLabel JL207;
    private JLabel JL208;
    private JLabel JL209;
    private JLabel JL210;
    private JLabel JL211;
    private JLabel JL212;
    private JLabel JL213;
    private JLabel JL214;
    private JLabel JL215;
    private JLabel JL216;
    private JLabel JL217;
    private JLabel JL218;
    private JLabel JL219;
    private JLabel JL220;
    private JLabel JL221;
    private JLabel JL222;
    private JLabel JL223;
    private JLabel JL224;
    private JLabel JL225;
    private JLabel JL226;
    private JLabel JL227;
    private JLabel JL228;
    private JLabel JL229;
    private JLabel JL230;
    private JLabel JL231;
    private JLabel JL232;
    private JLabel JL233;
    private JLabel JL234;
    private JLabel JL235;
    private JLabel JL236;
    private JLabel JL237;
    private JLabel JL238;
    private JLabel JL239;
    private JLabel JL240;
    private JLabel JL241;
    private JLabel JL242;
    private JLabel JL243;
    private JLabel JL244;
    private JLabel JL245;
    private JLabel JL246;
    private JLabel JL247;
    private JLabel JL248;
    private JLabel JL249;
    private JLabel JL250;
    private JLabel JL251;
    private JLabel JL252;
    private JLabel JL253;
    private JLabel JL254;
    private JLabel JL255;
    private JLabel JL256;
    private JLabel JLDBlanco33;
    private JLabel JLDBlanco34;
    private JLabel JLDBlanco35;
    private JLabel JLDBlanco36;
    private JLabel JLDBlanco37;
    private JLabel JLDBlanco38;
    private JLabel JLDBlanco39;
    private JLabel JLDBlanco40;
    private JLabel JLDBlanco41;
    private JLabel JLDBlanco42;
    private JLabel JLDBlanco43;
    private JLabel JLDBlanco44;
    private JLabel JLDBlanco45;
    private JLabel JLDBlanco46;
    private JLabel JLDBlanco47;
    private JLabel JLDBlanco48;
    private JLabel JLDBlanco49;
    private JLabel JLDBlanco50;
    private JLabel JLDBlanco51;
    private JLabel JLDBlanco52;
    private JLabel JLDBlanco53;
    private JLabel JLDBlanco54;
    private JLabel JLDBlanco55;
    private JLabel JLDBlanco56;
    private JLabel JLDBlanco57;
    private JLabel JLDBlanco58;
    private JLabel JLDBlanco59;
    private JLabel JLDBlanco60;
    private JLabel JLDBlanco61;
    private JLabel JLDBlanco62;
    private JLabel JLDBlanco63;
    private JLabel JLDBlanco64;
    private JPanel JP33;
    private JPanel JP34;
    private JPanel JP35;
    private JPanel JP36;
    private JPanel JP37;
    private JPanel JP38;
    private JPanel JP39;
    private JPanel JP40;
    private JPanel JP41;
    private JPanel JP42;
    private JPanel JP43;
    private JPanel JP44;
    private JPanel JP45;
    private JPanel JP46;
    private JPanel JP47;
    private JPanel JP48;
    private JPanel JP49;
    private JPanel JP50;
    private JPanel JP51;
    private JPanel JP52;
    private JPanel JP53;
    private JPanel JP54;
    private JPanel JP55;
    private JPanel JP56;
    private JPanel JP57;
    private JPanel JP58;
    private JPanel JP59;
    private JPanel JP60;
    private JPanel JP61;
    private JPanel JP62;
    private JPanel JP63;
    private JPanel JP64;
    public JPanel JPImOdontogramaHistorico;
    private JLabel jLabel34;
    private JLabel jLabel35;
    private JLabel jLabel36;
    private JLabel jLabel37;
    private JLabel jLabel38;
    private JLabel jLabel39;
    private JLabel jLabel40;
    private JLabel jLabel41;
    private JLabel jLabel42;
    private JLabel jLabel43;
    private JLabel jLabel44;
    private JLabel jLabel45;
    private JLabel jLabel46;
    private JLabel jLabel47;
    private JLabel jLabel48;
    private JLabel jLabel49;
    private JLabel jLabel50;
    private JLabel jLabel51;
    private JLabel jLabel52;
    private JLabel jLabel53;
    private JLabel jLabel54;
    private JLabel jLabel55;
    private JLabel jLabel56;
    private JLabel jLabel57;
    private JLabel jLabel58;
    private JLabel jLabel59;
    private JLabel jLabel60;
    private JLabel jLabel61;
    private JLabel jLabel62;
    private JLabel jLabel63;
    private JLabel jLabel64;
    private JLabel jLabel65;

    public JPOdontogramaControlPlaca() {
        initComponents();
        System.out.println("----->Entró al panel de Control Placa<----");
    }

    private void initComponents() {
        this.JPImOdontogramaHistorico = new JPanel();
        this.JP33 = new JPanel();
        this.JL129 = new JLabel();
        this.JL130 = new JLabel();
        this.JL131 = new JLabel();
        this.JL132 = new JLabel();
        this.JLDBlanco33 = new JLabel();
        this.jLabel34 = new JLabel();
        this.JP34 = new JPanel();
        this.JL133 = new JLabel();
        this.JL134 = new JLabel();
        this.JL135 = new JLabel();
        this.JL136 = new JLabel();
        this.JLDBlanco34 = new JLabel();
        this.jLabel35 = new JLabel();
        this.JP35 = new JPanel();
        this.JL137 = new JLabel();
        this.JL138 = new JLabel();
        this.JL139 = new JLabel();
        this.JL140 = new JLabel();
        this.JLDBlanco35 = new JLabel();
        this.jLabel36 = new JLabel();
        this.JP36 = new JPanel();
        this.JL141 = new JLabel();
        this.JL142 = new JLabel();
        this.JL143 = new JLabel();
        this.JL144 = new JLabel();
        this.JLDBlanco36 = new JLabel();
        this.jLabel37 = new JLabel();
        this.JP37 = new JPanel();
        this.JL145 = new JLabel();
        this.JL146 = new JLabel();
        this.JL147 = new JLabel();
        this.JL148 = new JLabel();
        this.JLDBlanco37 = new JLabel();
        this.jLabel38 = new JLabel();
        this.JP38 = new JPanel();
        this.JL149 = new JLabel();
        this.JL150 = new JLabel();
        this.JL151 = new JLabel();
        this.JL152 = new JLabel();
        this.JLDBlanco38 = new JLabel();
        this.jLabel39 = new JLabel();
        this.JP39 = new JPanel();
        this.JL153 = new JLabel();
        this.JL154 = new JLabel();
        this.JL155 = new JLabel();
        this.JL156 = new JLabel();
        this.JLDBlanco39 = new JLabel();
        this.jLabel40 = new JLabel();
        this.JP40 = new JPanel();
        this.JL157 = new JLabel();
        this.JL158 = new JLabel();
        this.JL159 = new JLabel();
        this.JL160 = new JLabel();
        this.JLDBlanco40 = new JLabel();
        this.jLabel41 = new JLabel();
        this.JP41 = new JPanel();
        this.JL161 = new JLabel();
        this.JL162 = new JLabel();
        this.JL163 = new JLabel();
        this.JL164 = new JLabel();
        this.JLDBlanco41 = new JLabel();
        this.jLabel42 = new JLabel();
        this.JP42 = new JPanel();
        this.JL165 = new JLabel();
        this.JL166 = new JLabel();
        this.JL167 = new JLabel();
        this.JL168 = new JLabel();
        this.JLDBlanco42 = new JLabel();
        this.jLabel43 = new JLabel();
        this.JP43 = new JPanel();
        this.JL169 = new JLabel();
        this.JL170 = new JLabel();
        this.JL171 = new JLabel();
        this.JL172 = new JLabel();
        this.JLDBlanco43 = new JLabel();
        this.jLabel44 = new JLabel();
        this.JP44 = new JPanel();
        this.JL173 = new JLabel();
        this.JL174 = new JLabel();
        this.JL175 = new JLabel();
        this.JL176 = new JLabel();
        this.JLDBlanco44 = new JLabel();
        this.jLabel45 = new JLabel();
        this.JP45 = new JPanel();
        this.JL177 = new JLabel();
        this.JL178 = new JLabel();
        this.JL179 = new JLabel();
        this.JL180 = new JLabel();
        this.JLDBlanco45 = new JLabel();
        this.jLabel46 = new JLabel();
        this.JP46 = new JPanel();
        this.JL181 = new JLabel();
        this.JL182 = new JLabel();
        this.JL183 = new JLabel();
        this.JL184 = new JLabel();
        this.JLDBlanco46 = new JLabel();
        this.jLabel47 = new JLabel();
        this.JP47 = new JPanel();
        this.JL185 = new JLabel();
        this.JL186 = new JLabel();
        this.JL187 = new JLabel();
        this.JL188 = new JLabel();
        this.JLDBlanco47 = new JLabel();
        this.jLabel48 = new JLabel();
        this.JP48 = new JPanel();
        this.JL189 = new JLabel();
        this.JL190 = new JLabel();
        this.JL191 = new JLabel();
        this.JL192 = new JLabel();
        this.JLDBlanco48 = new JLabel();
        this.jLabel49 = new JLabel();
        this.jLabel50 = new JLabel();
        this.JP49 = new JPanel();
        this.JL193 = new JLabel();
        this.JL194 = new JLabel();
        this.JL195 = new JLabel();
        this.JL196 = new JLabel();
        this.JLDBlanco49 = new JLabel();
        this.jLabel51 = new JLabel();
        this.JP50 = new JPanel();
        this.JL197 = new JLabel();
        this.JL198 = new JLabel();
        this.JL199 = new JLabel();
        this.JL200 = new JLabel();
        this.JLDBlanco50 = new JLabel();
        this.jLabel52 = new JLabel();
        this.JP51 = new JPanel();
        this.JL201 = new JLabel();
        this.JL202 = new JLabel();
        this.JL203 = new JLabel();
        this.JL204 = new JLabel();
        this.JLDBlanco51 = new JLabel();
        this.jLabel53 = new JLabel();
        this.JP52 = new JPanel();
        this.JL205 = new JLabel();
        this.JL206 = new JLabel();
        this.JL207 = new JLabel();
        this.JL208 = new JLabel();
        this.JLDBlanco52 = new JLabel();
        this.jLabel54 = new JLabel();
        this.JP53 = new JPanel();
        this.JL209 = new JLabel();
        this.JL210 = new JLabel();
        this.JL211 = new JLabel();
        this.JL212 = new JLabel();
        this.JLDBlanco53 = new JLabel();
        this.jLabel55 = new JLabel();
        this.JP54 = new JPanel();
        this.JL213 = new JLabel();
        this.JL214 = new JLabel();
        this.JL215 = new JLabel();
        this.JL216 = new JLabel();
        this.JLDBlanco54 = new JLabel();
        this.jLabel56 = new JLabel();
        this.JP55 = new JPanel();
        this.JL217 = new JLabel();
        this.JL218 = new JLabel();
        this.JL219 = new JLabel();
        this.JL220 = new JLabel();
        this.JLDBlanco55 = new JLabel();
        this.jLabel57 = new JLabel();
        this.JP56 = new JPanel();
        this.JL221 = new JLabel();
        this.JL222 = new JLabel();
        this.JL223 = new JLabel();
        this.JL224 = new JLabel();
        this.JLDBlanco56 = new JLabel();
        this.jLabel58 = new JLabel();
        this.JP57 = new JPanel();
        this.JL225 = new JLabel();
        this.JL226 = new JLabel();
        this.JL227 = new JLabel();
        this.JL228 = new JLabel();
        this.JLDBlanco57 = new JLabel();
        this.jLabel59 = new JLabel();
        this.JP58 = new JPanel();
        this.JL229 = new JLabel();
        this.JL230 = new JLabel();
        this.JL231 = new JLabel();
        this.JL232 = new JLabel();
        this.JLDBlanco58 = new JLabel();
        this.jLabel60 = new JLabel();
        this.JP59 = new JPanel();
        this.JL233 = new JLabel();
        this.JL234 = new JLabel();
        this.JL235 = new JLabel();
        this.JL236 = new JLabel();
        this.JLDBlanco59 = new JLabel();
        this.jLabel61 = new JLabel();
        this.JP60 = new JPanel();
        this.JL237 = new JLabel();
        this.JL238 = new JLabel();
        this.JL239 = new JLabel();
        this.JL240 = new JLabel();
        this.JLDBlanco60 = new JLabel();
        this.jLabel62 = new JLabel();
        this.JP61 = new JPanel();
        this.JL241 = new JLabel();
        this.JL242 = new JLabel();
        this.JL243 = new JLabel();
        this.JL244 = new JLabel();
        this.JLDBlanco61 = new JLabel();
        this.jLabel63 = new JLabel();
        this.JP62 = new JPanel();
        this.JL245 = new JLabel();
        this.JL246 = new JLabel();
        this.JL247 = new JLabel();
        this.JL248 = new JLabel();
        this.JLDBlanco62 = new JLabel();
        this.jLabel64 = new JLabel();
        this.JP63 = new JPanel();
        this.JL249 = new JLabel();
        this.JL250 = new JLabel();
        this.JL251 = new JLabel();
        this.JL252 = new JLabel();
        this.JLDBlanco63 = new JLabel();
        this.jLabel65 = new JLabel();
        this.JP64 = new JPanel();
        this.JL253 = new JLabel();
        this.JL254 = new JLabel();
        this.JL255 = new JLabel();
        this.JL256 = new JLabel();
        this.JLDBlanco64 = new JLabel();
        this.JPImOdontogramaHistorico.setBackground(new Color(255, 255, 255));
        this.JP33.setMaximumSize(new Dimension(41, 45));
        this.JP33.setMinimumSize(new Dimension(41, 45));
        this.JP33.setName("1");
        this.JP33.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.1
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP33MouseClicked(evt);
            }
        });
        this.JP33.setLayout((LayoutManager) null);
        this.JL129.setMaximumSize(new Dimension(41, 45));
        this.JL129.setMinimumSize(new Dimension(41, 45));
        this.JL129.setName("4");
        this.JL129.setPreferredSize(new Dimension(41, 45));
        this.JP33.add(this.JL129);
        this.JL129.setBounds(0, 0, 41, 45);
        this.JL130.setMaximumSize(new Dimension(41, 45));
        this.JL130.setMinimumSize(new Dimension(41, 45));
        this.JL130.setName("3");
        this.JL130.setPreferredSize(new Dimension(41, 45));
        this.JP33.add(this.JL130);
        this.JL130.setBounds(0, 0, 41, 45);
        this.JL131.setMaximumSize(new Dimension(41, 45));
        this.JL131.setMinimumSize(new Dimension(41, 45));
        this.JL131.setName("2");
        this.JL131.setPreferredSize(new Dimension(41, 45));
        this.JP33.add(this.JL131);
        this.JL131.setBounds(0, 0, 41, 45);
        this.JL132.setMaximumSize(new Dimension(41, 45));
        this.JL132.setMinimumSize(new Dimension(41, 45));
        this.JL132.setName("1");
        this.JL132.setPreferredSize(new Dimension(41, 45));
        this.JP33.add(this.JL132);
        this.JL132.setBounds(0, 0, 41, 45);
        this.JLDBlanco33.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco33.setName("0");
        this.JP33.add(this.JLDBlanco33);
        this.JLDBlanco33.setBounds(0, 0, 41, 45);
        this.jLabel34.setFont(new Font("Arial", 1, 12));
        this.jLabel34.setHorizontalAlignment(0);
        this.jLabel34.setText("1");
        this.JP34.setMaximumSize(new Dimension(41, 45));
        this.JP34.setMinimumSize(new Dimension(41, 45));
        this.JP34.setName("2");
        this.JP34.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.2
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP34MouseClicked(evt);
            }
        });
        this.JP34.setLayout((LayoutManager) null);
        this.JL133.setMaximumSize(new Dimension(41, 45));
        this.JL133.setMinimumSize(new Dimension(41, 45));
        this.JL133.setName("4");
        this.JL133.setPreferredSize(new Dimension(41, 45));
        this.JP34.add(this.JL133);
        this.JL133.setBounds(0, 0, 41, 45);
        this.JL134.setMaximumSize(new Dimension(41, 45));
        this.JL134.setMinimumSize(new Dimension(41, 45));
        this.JL134.setName("3");
        this.JL134.setPreferredSize(new Dimension(41, 45));
        this.JP34.add(this.JL134);
        this.JL134.setBounds(0, 0, 41, 45);
        this.JL135.setMaximumSize(new Dimension(41, 45));
        this.JL135.setMinimumSize(new Dimension(41, 45));
        this.JL135.setName("2");
        this.JL135.setPreferredSize(new Dimension(41, 45));
        this.JP34.add(this.JL135);
        this.JL135.setBounds(0, 0, 41, 45);
        this.JL136.setMaximumSize(new Dimension(41, 45));
        this.JL136.setMinimumSize(new Dimension(41, 45));
        this.JL136.setName("1");
        this.JL136.setPreferredSize(new Dimension(41, 45));
        this.JP34.add(this.JL136);
        this.JL136.setBounds(0, 0, 41, 45);
        this.JLDBlanco34.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco34.setName("0");
        this.JP34.add(this.JLDBlanco34);
        this.JLDBlanco34.setBounds(0, 0, 41, 45);
        this.jLabel35.setFont(new Font("Arial", 1, 12));
        this.jLabel35.setHorizontalAlignment(0);
        this.jLabel35.setText("2");
        this.JP35.setMaximumSize(new Dimension(41, 45));
        this.JP35.setMinimumSize(new Dimension(41, 45));
        this.JP35.setName("3");
        this.JP35.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.3
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP35MouseClicked(evt);
            }
        });
        this.JP35.setLayout((LayoutManager) null);
        this.JL137.setMaximumSize(new Dimension(41, 45));
        this.JL137.setMinimumSize(new Dimension(41, 45));
        this.JL137.setName("4");
        this.JL137.setPreferredSize(new Dimension(41, 45));
        this.JP35.add(this.JL137);
        this.JL137.setBounds(0, 0, 41, 45);
        this.JL138.setMaximumSize(new Dimension(41, 45));
        this.JL138.setMinimumSize(new Dimension(41, 45));
        this.JL138.setName("3");
        this.JL138.setPreferredSize(new Dimension(41, 45));
        this.JP35.add(this.JL138);
        this.JL138.setBounds(0, 0, 41, 45);
        this.JL139.setMaximumSize(new Dimension(41, 45));
        this.JL139.setMinimumSize(new Dimension(41, 45));
        this.JL139.setName("2");
        this.JL139.setPreferredSize(new Dimension(41, 45));
        this.JP35.add(this.JL139);
        this.JL139.setBounds(0, 0, 41, 45);
        this.JL140.setMaximumSize(new Dimension(41, 45));
        this.JL140.setMinimumSize(new Dimension(41, 45));
        this.JL140.setName("1");
        this.JL140.setPreferredSize(new Dimension(41, 45));
        this.JP35.add(this.JL140);
        this.JL140.setBounds(0, 0, 41, 45);
        this.JLDBlanco35.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco35.setName("0");
        this.JP35.add(this.JLDBlanco35);
        this.JLDBlanco35.setBounds(0, 0, 41, 45);
        this.jLabel36.setFont(new Font("Arial", 1, 12));
        this.jLabel36.setHorizontalAlignment(0);
        this.jLabel36.setText("3");
        this.JP36.setMaximumSize(new Dimension(41, 45));
        this.JP36.setMinimumSize(new Dimension(41, 45));
        this.JP36.setName("4");
        this.JP36.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.4
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP36MouseClicked(evt);
            }
        });
        this.JP36.setLayout((LayoutManager) null);
        this.JL141.setMaximumSize(new Dimension(41, 45));
        this.JL141.setMinimumSize(new Dimension(41, 45));
        this.JL141.setName("4");
        this.JL141.setPreferredSize(new Dimension(41, 45));
        this.JP36.add(this.JL141);
        this.JL141.setBounds(0, 0, 41, 45);
        this.JL142.setMaximumSize(new Dimension(41, 45));
        this.JL142.setMinimumSize(new Dimension(41, 45));
        this.JL142.setName("3");
        this.JL142.setPreferredSize(new Dimension(41, 45));
        this.JP36.add(this.JL142);
        this.JL142.setBounds(0, 0, 41, 45);
        this.JL143.setMaximumSize(new Dimension(41, 45));
        this.JL143.setMinimumSize(new Dimension(41, 45));
        this.JL143.setName("2");
        this.JL143.setPreferredSize(new Dimension(41, 45));
        this.JP36.add(this.JL143);
        this.JL143.setBounds(0, 0, 41, 45);
        this.JL144.setMaximumSize(new Dimension(41, 45));
        this.JL144.setMinimumSize(new Dimension(41, 45));
        this.JL144.setName("1");
        this.JL144.setPreferredSize(new Dimension(41, 45));
        this.JP36.add(this.JL144);
        this.JL144.setBounds(0, 0, 41, 45);
        this.JLDBlanco36.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco36.setName("0");
        this.JP36.add(this.JLDBlanco36);
        this.JLDBlanco36.setBounds(0, 0, 41, 45);
        this.jLabel37.setFont(new Font("Arial", 1, 12));
        this.jLabel37.setHorizontalAlignment(0);
        this.jLabel37.setText("4");
        this.JP37.setMaximumSize(new Dimension(41, 45));
        this.JP37.setMinimumSize(new Dimension(41, 45));
        this.JP37.setName("5");
        this.JP37.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.5
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP37MouseClicked(evt);
            }
        });
        this.JP37.setLayout((LayoutManager) null);
        this.JL145.setMaximumSize(new Dimension(41, 45));
        this.JL145.setMinimumSize(new Dimension(41, 45));
        this.JL145.setName("4");
        this.JL145.setPreferredSize(new Dimension(41, 45));
        this.JP37.add(this.JL145);
        this.JL145.setBounds(0, 0, 41, 45);
        this.JL146.setMaximumSize(new Dimension(41, 45));
        this.JL146.setMinimumSize(new Dimension(41, 45));
        this.JL146.setName("3");
        this.JL146.setPreferredSize(new Dimension(41, 45));
        this.JP37.add(this.JL146);
        this.JL146.setBounds(0, 0, 41, 45);
        this.JL147.setMaximumSize(new Dimension(41, 45));
        this.JL147.setMinimumSize(new Dimension(41, 45));
        this.JL147.setName("2");
        this.JL147.setPreferredSize(new Dimension(41, 45));
        this.JP37.add(this.JL147);
        this.JL147.setBounds(0, 0, 41, 45);
        this.JL148.setMaximumSize(new Dimension(41, 45));
        this.JL148.setMinimumSize(new Dimension(41, 45));
        this.JL148.setName("1");
        this.JL148.setPreferredSize(new Dimension(41, 45));
        this.JP37.add(this.JL148);
        this.JL148.setBounds(0, 0, 41, 45);
        this.JLDBlanco37.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco37.setName("0");
        this.JP37.add(this.JLDBlanco37);
        this.JLDBlanco37.setBounds(0, 0, 41, 45);
        this.jLabel38.setFont(new Font("Arial", 1, 12));
        this.jLabel38.setHorizontalAlignment(0);
        this.jLabel38.setText("5");
        this.JP38.setMaximumSize(new Dimension(41, 45));
        this.JP38.setMinimumSize(new Dimension(41, 45));
        this.JP38.setName("6");
        this.JP38.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.6
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP38MouseClicked(evt);
            }
        });
        this.JP38.setLayout((LayoutManager) null);
        this.JL149.setMaximumSize(new Dimension(41, 45));
        this.JL149.setMinimumSize(new Dimension(41, 45));
        this.JL149.setName("4");
        this.JL149.setPreferredSize(new Dimension(41, 45));
        this.JP38.add(this.JL149);
        this.JL149.setBounds(0, 0, 41, 45);
        this.JL150.setMaximumSize(new Dimension(41, 45));
        this.JL150.setMinimumSize(new Dimension(41, 45));
        this.JL150.setName("3");
        this.JL150.setPreferredSize(new Dimension(41, 45));
        this.JP38.add(this.JL150);
        this.JL150.setBounds(0, 0, 41, 45);
        this.JL151.setMaximumSize(new Dimension(41, 45));
        this.JL151.setMinimumSize(new Dimension(41, 45));
        this.JL151.setName("2");
        this.JL151.setPreferredSize(new Dimension(41, 45));
        this.JP38.add(this.JL151);
        this.JL151.setBounds(0, 0, 41, 45);
        this.JL152.setMaximumSize(new Dimension(41, 45));
        this.JL152.setMinimumSize(new Dimension(41, 45));
        this.JL152.setName("1");
        this.JL152.setPreferredSize(new Dimension(41, 45));
        this.JP38.add(this.JL152);
        this.JL152.setBounds(0, 0, 41, 45);
        this.JLDBlanco38.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco38.setName("0");
        this.JP38.add(this.JLDBlanco38);
        this.JLDBlanco38.setBounds(0, 0, 41, 45);
        this.jLabel39.setFont(new Font("Arial", 1, 12));
        this.jLabel39.setHorizontalAlignment(0);
        this.jLabel39.setText("6");
        this.JP39.setMaximumSize(new Dimension(41, 45));
        this.JP39.setMinimumSize(new Dimension(41, 45));
        this.JP39.setName("7");
        this.JP39.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.7
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP39MouseClicked(evt);
            }
        });
        this.JP39.setLayout((LayoutManager) null);
        this.JL153.setMaximumSize(new Dimension(41, 45));
        this.JL153.setMinimumSize(new Dimension(41, 45));
        this.JL153.setName("4");
        this.JL153.setPreferredSize(new Dimension(41, 45));
        this.JP39.add(this.JL153);
        this.JL153.setBounds(0, 0, 41, 45);
        this.JL154.setMaximumSize(new Dimension(41, 45));
        this.JL154.setMinimumSize(new Dimension(41, 45));
        this.JL154.setName("3");
        this.JL154.setPreferredSize(new Dimension(41, 45));
        this.JP39.add(this.JL154);
        this.JL154.setBounds(0, 0, 41, 45);
        this.JL155.setMaximumSize(new Dimension(41, 45));
        this.JL155.setMinimumSize(new Dimension(41, 45));
        this.JL155.setName("2");
        this.JL155.setPreferredSize(new Dimension(41, 45));
        this.JP39.add(this.JL155);
        this.JL155.setBounds(0, 0, 41, 45);
        this.JL156.setMaximumSize(new Dimension(41, 45));
        this.JL156.setMinimumSize(new Dimension(41, 45));
        this.JL156.setName("1");
        this.JL156.setPreferredSize(new Dimension(41, 45));
        this.JP39.add(this.JL156);
        this.JL156.setBounds(0, 0, 41, 45);
        this.JLDBlanco39.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco39.setName("0");
        this.JP39.add(this.JLDBlanco39);
        this.JLDBlanco39.setBounds(0, 0, 41, 45);
        this.jLabel40.setFont(new Font("Arial", 1, 12));
        this.jLabel40.setHorizontalAlignment(0);
        this.jLabel40.setText("7");
        this.JP40.setMaximumSize(new Dimension(41, 45));
        this.JP40.setMinimumSize(new Dimension(41, 45));
        this.JP40.setName("8");
        this.JP40.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.8
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP40MouseClicked(evt);
            }
        });
        this.JP40.setLayout((LayoutManager) null);
        this.JL157.setMaximumSize(new Dimension(41, 45));
        this.JL157.setMinimumSize(new Dimension(41, 45));
        this.JL157.setName("4");
        this.JL157.setPreferredSize(new Dimension(41, 45));
        this.JP40.add(this.JL157);
        this.JL157.setBounds(0, 0, 41, 45);
        this.JL158.setMaximumSize(new Dimension(41, 45));
        this.JL158.setMinimumSize(new Dimension(41, 45));
        this.JL158.setName("3");
        this.JL158.setPreferredSize(new Dimension(41, 45));
        this.JP40.add(this.JL158);
        this.JL158.setBounds(0, 0, 41, 45);
        this.JL159.setMaximumSize(new Dimension(41, 45));
        this.JL159.setMinimumSize(new Dimension(41, 45));
        this.JL159.setName("2");
        this.JL159.setPreferredSize(new Dimension(41, 45));
        this.JP40.add(this.JL159);
        this.JL159.setBounds(0, 0, 41, 45);
        this.JL160.setMaximumSize(new Dimension(41, 45));
        this.JL160.setMinimumSize(new Dimension(41, 45));
        this.JL160.setName("1");
        this.JL160.setPreferredSize(new Dimension(41, 45));
        this.JP40.add(this.JL160);
        this.JL160.setBounds(0, 0, 41, 45);
        this.JLDBlanco40.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco40.setName("0");
        this.JP40.add(this.JLDBlanco40);
        this.JLDBlanco40.setBounds(0, 0, 41, 45);
        this.jLabel41.setFont(new Font("Arial", 1, 12));
        this.jLabel41.setHorizontalAlignment(0);
        this.jLabel41.setText("8");
        this.JP41.setMaximumSize(new Dimension(41, 45));
        this.JP41.setMinimumSize(new Dimension(41, 45));
        this.JP41.setName("9");
        this.JP41.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.9
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP41MouseClicked(evt);
            }
        });
        this.JP41.setLayout((LayoutManager) null);
        this.JL161.setMaximumSize(new Dimension(41, 45));
        this.JL161.setMinimumSize(new Dimension(41, 45));
        this.JL161.setName("4");
        this.JL161.setPreferredSize(new Dimension(41, 45));
        this.JP41.add(this.JL161);
        this.JL161.setBounds(0, 0, 41, 45);
        this.JL162.setMaximumSize(new Dimension(41, 45));
        this.JL162.setMinimumSize(new Dimension(41, 45));
        this.JL162.setName("3");
        this.JL162.setPreferredSize(new Dimension(41, 45));
        this.JP41.add(this.JL162);
        this.JL162.setBounds(0, 0, 41, 45);
        this.JL163.setMaximumSize(new Dimension(41, 45));
        this.JL163.setMinimumSize(new Dimension(41, 45));
        this.JL163.setName("2");
        this.JL163.setPreferredSize(new Dimension(41, 45));
        this.JP41.add(this.JL163);
        this.JL163.setBounds(0, 0, 41, 45);
        this.JL164.setMaximumSize(new Dimension(41, 45));
        this.JL164.setMinimumSize(new Dimension(41, 45));
        this.JL164.setName("1");
        this.JL164.setPreferredSize(new Dimension(41, 45));
        this.JP41.add(this.JL164);
        this.JL164.setBounds(0, 0, 41, 45);
        this.JLDBlanco41.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco41.setName("0");
        this.JP41.add(this.JLDBlanco41);
        this.JLDBlanco41.setBounds(0, 0, 41, 45);
        this.jLabel42.setFont(new Font("Arial", 1, 12));
        this.jLabel42.setHorizontalAlignment(0);
        this.jLabel42.setText("9");
        this.JP42.setMaximumSize(new Dimension(41, 45));
        this.JP42.setMinimumSize(new Dimension(41, 45));
        this.JP42.setName("10");
        this.JP42.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.10
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP42MouseClicked(evt);
            }
        });
        this.JP42.setLayout((LayoutManager) null);
        this.JL165.setMaximumSize(new Dimension(41, 45));
        this.JL165.setMinimumSize(new Dimension(41, 45));
        this.JL165.setName("4");
        this.JL165.setPreferredSize(new Dimension(41, 45));
        this.JP42.add(this.JL165);
        this.JL165.setBounds(0, 0, 41, 45);
        this.JL166.setMaximumSize(new Dimension(41, 45));
        this.JL166.setMinimumSize(new Dimension(41, 45));
        this.JL166.setName("3");
        this.JL166.setPreferredSize(new Dimension(41, 45));
        this.JP42.add(this.JL166);
        this.JL166.setBounds(0, 0, 41, 45);
        this.JL167.setMaximumSize(new Dimension(41, 45));
        this.JL167.setMinimumSize(new Dimension(41, 45));
        this.JL167.setName("2");
        this.JL167.setPreferredSize(new Dimension(41, 45));
        this.JP42.add(this.JL167);
        this.JL167.setBounds(0, 0, 41, 45);
        this.JL168.setMaximumSize(new Dimension(41, 45));
        this.JL168.setMinimumSize(new Dimension(41, 45));
        this.JL168.setName("1");
        this.JL168.setPreferredSize(new Dimension(41, 45));
        this.JP42.add(this.JL168);
        this.JL168.setBounds(0, 0, 41, 45);
        this.JLDBlanco42.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco42.setName("0");
        this.JP42.add(this.JLDBlanco42);
        this.JLDBlanco42.setBounds(0, 0, 41, 45);
        this.jLabel43.setFont(new Font("Arial", 1, 12));
        this.jLabel43.setHorizontalAlignment(0);
        this.jLabel43.setText("10");
        this.JP43.setMaximumSize(new Dimension(41, 45));
        this.JP43.setMinimumSize(new Dimension(41, 45));
        this.JP43.setName("11");
        this.JP43.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.11
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP43MouseClicked(evt);
            }
        });
        this.JP43.setLayout((LayoutManager) null);
        this.JL169.setMaximumSize(new Dimension(41, 45));
        this.JL169.setMinimumSize(new Dimension(41, 45));
        this.JL169.setName("4");
        this.JL169.setPreferredSize(new Dimension(41, 45));
        this.JP43.add(this.JL169);
        this.JL169.setBounds(0, 0, 41, 45);
        this.JL170.setMaximumSize(new Dimension(41, 45));
        this.JL170.setMinimumSize(new Dimension(41, 45));
        this.JL170.setName("3");
        this.JL170.setPreferredSize(new Dimension(41, 45));
        this.JP43.add(this.JL170);
        this.JL170.setBounds(0, 0, 41, 45);
        this.JL171.setMaximumSize(new Dimension(41, 45));
        this.JL171.setMinimumSize(new Dimension(41, 45));
        this.JL171.setName("2");
        this.JL171.setPreferredSize(new Dimension(41, 45));
        this.JP43.add(this.JL171);
        this.JL171.setBounds(0, 0, 41, 45);
        this.JL172.setMaximumSize(new Dimension(41, 45));
        this.JL172.setMinimumSize(new Dimension(41, 45));
        this.JL172.setName("1");
        this.JL172.setPreferredSize(new Dimension(41, 45));
        this.JP43.add(this.JL172);
        this.JL172.setBounds(0, 0, 41, 45);
        this.JLDBlanco43.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco43.setName("0");
        this.JP43.add(this.JLDBlanco43);
        this.JLDBlanco43.setBounds(0, 0, 41, 45);
        this.jLabel44.setFont(new Font("Arial", 1, 12));
        this.jLabel44.setHorizontalAlignment(0);
        this.jLabel44.setText("11");
        this.JP44.setMaximumSize(new Dimension(41, 45));
        this.JP44.setMinimumSize(new Dimension(41, 45));
        this.JP44.setName("12");
        this.JP44.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.12
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP44MouseClicked(evt);
            }
        });
        this.JP44.setLayout((LayoutManager) null);
        this.JL173.setMaximumSize(new Dimension(41, 45));
        this.JL173.setMinimumSize(new Dimension(41, 45));
        this.JL173.setName("4");
        this.JL173.setPreferredSize(new Dimension(41, 45));
        this.JP44.add(this.JL173);
        this.JL173.setBounds(0, 0, 41, 45);
        this.JL174.setMaximumSize(new Dimension(41, 45));
        this.JL174.setMinimumSize(new Dimension(41, 45));
        this.JL174.setName("3");
        this.JL174.setPreferredSize(new Dimension(41, 45));
        this.JP44.add(this.JL174);
        this.JL174.setBounds(0, 0, 41, 45);
        this.JL175.setMaximumSize(new Dimension(41, 45));
        this.JL175.setMinimumSize(new Dimension(41, 45));
        this.JL175.setName("2");
        this.JL175.setPreferredSize(new Dimension(41, 45));
        this.JP44.add(this.JL175);
        this.JL175.setBounds(0, 0, 41, 45);
        this.JL176.setMaximumSize(new Dimension(41, 45));
        this.JL176.setMinimumSize(new Dimension(41, 45));
        this.JL176.setName("1");
        this.JL176.setPreferredSize(new Dimension(41, 45));
        this.JP44.add(this.JL176);
        this.JL176.setBounds(0, 0, 41, 45);
        this.JLDBlanco44.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco44.setName("0");
        this.JP44.add(this.JLDBlanco44);
        this.JLDBlanco44.setBounds(0, 0, 41, 45);
        this.jLabel45.setFont(new Font("Arial", 1, 12));
        this.jLabel45.setHorizontalAlignment(0);
        this.jLabel45.setText("12");
        this.JP45.setMaximumSize(new Dimension(41, 45));
        this.JP45.setMinimumSize(new Dimension(41, 45));
        this.JP45.setName("13");
        this.JP45.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.13
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP45MouseClicked(evt);
            }
        });
        this.JP45.setLayout((LayoutManager) null);
        this.JL177.setMaximumSize(new Dimension(41, 45));
        this.JL177.setMinimumSize(new Dimension(41, 45));
        this.JL177.setName("4");
        this.JL177.setPreferredSize(new Dimension(41, 45));
        this.JP45.add(this.JL177);
        this.JL177.setBounds(0, 0, 41, 45);
        this.JL178.setMaximumSize(new Dimension(41, 45));
        this.JL178.setMinimumSize(new Dimension(41, 45));
        this.JL178.setName("3");
        this.JL178.setPreferredSize(new Dimension(41, 45));
        this.JP45.add(this.JL178);
        this.JL178.setBounds(0, 0, 41, 45);
        this.JL179.setMaximumSize(new Dimension(41, 45));
        this.JL179.setMinimumSize(new Dimension(41, 45));
        this.JL179.setName("2");
        this.JL179.setPreferredSize(new Dimension(41, 45));
        this.JP45.add(this.JL179);
        this.JL179.setBounds(0, 0, 41, 45);
        this.JL180.setMaximumSize(new Dimension(41, 45));
        this.JL180.setMinimumSize(new Dimension(41, 45));
        this.JL180.setName("1");
        this.JL180.setPreferredSize(new Dimension(41, 45));
        this.JP45.add(this.JL180);
        this.JL180.setBounds(0, 0, 41, 45);
        this.JLDBlanco45.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco45.setName("0");
        this.JP45.add(this.JLDBlanco45);
        this.JLDBlanco45.setBounds(0, 0, 41, 45);
        this.jLabel46.setFont(new Font("Arial", 1, 12));
        this.jLabel46.setHorizontalAlignment(0);
        this.jLabel46.setText("13");
        this.JP46.setMaximumSize(new Dimension(41, 45));
        this.JP46.setMinimumSize(new Dimension(41, 45));
        this.JP46.setName("14");
        this.JP46.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.14
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP46MouseClicked(evt);
            }
        });
        this.JP46.setLayout((LayoutManager) null);
        this.JL181.setMaximumSize(new Dimension(41, 45));
        this.JL181.setMinimumSize(new Dimension(41, 45));
        this.JL181.setName("4");
        this.JL181.setPreferredSize(new Dimension(41, 45));
        this.JP46.add(this.JL181);
        this.JL181.setBounds(0, 0, 41, 45);
        this.JL182.setMaximumSize(new Dimension(41, 45));
        this.JL182.setMinimumSize(new Dimension(41, 45));
        this.JL182.setName("3");
        this.JL182.setPreferredSize(new Dimension(41, 45));
        this.JP46.add(this.JL182);
        this.JL182.setBounds(0, 0, 41, 45);
        this.JL183.setMaximumSize(new Dimension(41, 45));
        this.JL183.setMinimumSize(new Dimension(41, 45));
        this.JL183.setName("2");
        this.JL183.setPreferredSize(new Dimension(41, 45));
        this.JP46.add(this.JL183);
        this.JL183.setBounds(0, 0, 41, 45);
        this.JL184.setMaximumSize(new Dimension(41, 45));
        this.JL184.setMinimumSize(new Dimension(41, 45));
        this.JL184.setName("1");
        this.JL184.setPreferredSize(new Dimension(41, 45));
        this.JP46.add(this.JL184);
        this.JL184.setBounds(0, 0, 41, 45);
        this.JLDBlanco46.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco46.setName("0");
        this.JP46.add(this.JLDBlanco46);
        this.JLDBlanco46.setBounds(0, 0, 41, 45);
        this.jLabel47.setFont(new Font("Arial", 1, 12));
        this.jLabel47.setHorizontalAlignment(0);
        this.jLabel47.setText("14");
        this.JP47.setMaximumSize(new Dimension(41, 45));
        this.JP47.setMinimumSize(new Dimension(41, 45));
        this.JP47.setName("15");
        this.JP47.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.15
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP47MouseClicked(evt);
            }
        });
        this.JP47.setLayout((LayoutManager) null);
        this.JL185.setMaximumSize(new Dimension(41, 45));
        this.JL185.setMinimumSize(new Dimension(41, 45));
        this.JL185.setName("4");
        this.JL185.setPreferredSize(new Dimension(41, 45));
        this.JP47.add(this.JL185);
        this.JL185.setBounds(0, 0, 41, 45);
        this.JL186.setMaximumSize(new Dimension(41, 45));
        this.JL186.setMinimumSize(new Dimension(41, 45));
        this.JL186.setName("3");
        this.JL186.setPreferredSize(new Dimension(41, 45));
        this.JP47.add(this.JL186);
        this.JL186.setBounds(0, 0, 41, 45);
        this.JL187.setMaximumSize(new Dimension(41, 45));
        this.JL187.setMinimumSize(new Dimension(41, 45));
        this.JL187.setName("2");
        this.JL187.setPreferredSize(new Dimension(41, 45));
        this.JP47.add(this.JL187);
        this.JL187.setBounds(0, 0, 41, 45);
        this.JL188.setMaximumSize(new Dimension(41, 45));
        this.JL188.setMinimumSize(new Dimension(41, 45));
        this.JL188.setName("1");
        this.JL188.setPreferredSize(new Dimension(41, 45));
        this.JP47.add(this.JL188);
        this.JL188.setBounds(0, 0, 41, 45);
        this.JLDBlanco47.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco47.setName("0");
        this.JP47.add(this.JLDBlanco47);
        this.JLDBlanco47.setBounds(0, 0, 41, 45);
        this.jLabel48.setFont(new Font("Arial", 1, 12));
        this.jLabel48.setHorizontalAlignment(0);
        this.jLabel48.setText("15");
        this.JP48.setMaximumSize(new Dimension(41, 45));
        this.JP48.setMinimumSize(new Dimension(41, 45));
        this.JP48.setName("16");
        this.JP48.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.16
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP48MouseClicked(evt);
            }
        });
        this.JP48.setLayout((LayoutManager) null);
        this.JL189.setMaximumSize(new Dimension(41, 45));
        this.JL189.setMinimumSize(new Dimension(41, 45));
        this.JL189.setName("4");
        this.JL189.setPreferredSize(new Dimension(41, 45));
        this.JP48.add(this.JL189);
        this.JL189.setBounds(0, 0, 41, 45);
        this.JL190.setMaximumSize(new Dimension(41, 45));
        this.JL190.setMinimumSize(new Dimension(41, 45));
        this.JL190.setName("3");
        this.JL190.setPreferredSize(new Dimension(41, 45));
        this.JP48.add(this.JL190);
        this.JL190.setBounds(0, 0, 41, 45);
        this.JL191.setMaximumSize(new Dimension(41, 45));
        this.JL191.setMinimumSize(new Dimension(41, 45));
        this.JL191.setName("2");
        this.JL191.setPreferredSize(new Dimension(41, 45));
        this.JP48.add(this.JL191);
        this.JL191.setBounds(0, 0, 41, 45);
        this.JL192.setMaximumSize(new Dimension(41, 45));
        this.JL192.setMinimumSize(new Dimension(41, 45));
        this.JL192.setName("1");
        this.JL192.setPreferredSize(new Dimension(41, 45));
        this.JP48.add(this.JL192);
        this.JL192.setBounds(0, 0, 41, 45);
        this.JLDBlanco48.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco48.setName("0");
        this.JP48.add(this.JLDBlanco48);
        this.JLDBlanco48.setBounds(0, 0, 41, 45);
        this.jLabel49.setFont(new Font("Arial", 1, 12));
        this.jLabel49.setHorizontalAlignment(0);
        this.jLabel49.setText("16");
        this.jLabel50.setFont(new Font("Arial", 1, 12));
        this.jLabel50.setHorizontalAlignment(0);
        this.jLabel50.setText("17");
        this.JP49.setMaximumSize(new Dimension(41, 45));
        this.JP49.setMinimumSize(new Dimension(41, 45));
        this.JP49.setName("17");
        this.JP49.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.17
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP49MouseClicked(evt);
            }
        });
        this.JP49.setLayout((LayoutManager) null);
        this.JL193.setMaximumSize(new Dimension(41, 45));
        this.JL193.setMinimumSize(new Dimension(41, 45));
        this.JL193.setName("4");
        this.JL193.setPreferredSize(new Dimension(41, 45));
        this.JP49.add(this.JL193);
        this.JL193.setBounds(0, 0, 41, 45);
        this.JL194.setMaximumSize(new Dimension(41, 45));
        this.JL194.setMinimumSize(new Dimension(41, 45));
        this.JL194.setName("3");
        this.JL194.setPreferredSize(new Dimension(41, 45));
        this.JP49.add(this.JL194);
        this.JL194.setBounds(0, 0, 41, 45);
        this.JL195.setMaximumSize(new Dimension(41, 45));
        this.JL195.setMinimumSize(new Dimension(41, 45));
        this.JL195.setName("2");
        this.JL195.setPreferredSize(new Dimension(41, 45));
        this.JP49.add(this.JL195);
        this.JL195.setBounds(0, 0, 41, 45);
        this.JL196.setMaximumSize(new Dimension(41, 45));
        this.JL196.setMinimumSize(new Dimension(41, 45));
        this.JL196.setName("1");
        this.JL196.setPreferredSize(new Dimension(41, 45));
        this.JP49.add(this.JL196);
        this.JL196.setBounds(0, 0, 41, 45);
        this.JLDBlanco49.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco49.setName("0");
        this.JP49.add(this.JLDBlanco49);
        this.JLDBlanco49.setBounds(0, 0, 41, 45);
        this.jLabel51.setFont(new Font("Arial", 1, 12));
        this.jLabel51.setHorizontalAlignment(0);
        this.jLabel51.setText("18");
        this.JP50.setMaximumSize(new Dimension(41, 45));
        this.JP50.setMinimumSize(new Dimension(41, 45));
        this.JP50.setName("18");
        this.JP50.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.18
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP50MouseClicked(evt);
            }
        });
        this.JP50.setLayout((LayoutManager) null);
        this.JL197.setMaximumSize(new Dimension(41, 45));
        this.JL197.setMinimumSize(new Dimension(41, 45));
        this.JL197.setName("4");
        this.JL197.setPreferredSize(new Dimension(41, 45));
        this.JP50.add(this.JL197);
        this.JL197.setBounds(0, 0, 41, 45);
        this.JL198.setMaximumSize(new Dimension(41, 45));
        this.JL198.setMinimumSize(new Dimension(41, 45));
        this.JL198.setName("3");
        this.JL198.setPreferredSize(new Dimension(41, 45));
        this.JP50.add(this.JL198);
        this.JL198.setBounds(0, 0, 41, 45);
        this.JL199.setMaximumSize(new Dimension(41, 45));
        this.JL199.setMinimumSize(new Dimension(41, 45));
        this.JL199.setName("2");
        this.JL199.setPreferredSize(new Dimension(41, 45));
        this.JP50.add(this.JL199);
        this.JL199.setBounds(0, 0, 41, 45);
        this.JL200.setMaximumSize(new Dimension(41, 45));
        this.JL200.setMinimumSize(new Dimension(41, 45));
        this.JL200.setName("1");
        this.JL200.setPreferredSize(new Dimension(41, 45));
        this.JP50.add(this.JL200);
        this.JL200.setBounds(0, 0, 41, 45);
        this.JLDBlanco50.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco50.setName("0");
        this.JP50.add(this.JLDBlanco50);
        this.JLDBlanco50.setBounds(0, 0, 41, 45);
        this.jLabel52.setFont(new Font("Arial", 1, 12));
        this.jLabel52.setHorizontalAlignment(0);
        this.jLabel52.setText("19");
        this.JP51.setMaximumSize(new Dimension(41, 45));
        this.JP51.setMinimumSize(new Dimension(41, 45));
        this.JP51.setName("19");
        this.JP51.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.19
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP51MouseClicked(evt);
            }
        });
        this.JP51.setLayout((LayoutManager) null);
        this.JL201.setMaximumSize(new Dimension(41, 45));
        this.JL201.setMinimumSize(new Dimension(41, 45));
        this.JL201.setName("4");
        this.JL201.setPreferredSize(new Dimension(41, 45));
        this.JP51.add(this.JL201);
        this.JL201.setBounds(0, 0, 41, 45);
        this.JL202.setMaximumSize(new Dimension(41, 45));
        this.JL202.setMinimumSize(new Dimension(41, 45));
        this.JL202.setName("3");
        this.JL202.setPreferredSize(new Dimension(41, 45));
        this.JP51.add(this.JL202);
        this.JL202.setBounds(0, 0, 41, 45);
        this.JL203.setMaximumSize(new Dimension(41, 45));
        this.JL203.setMinimumSize(new Dimension(41, 45));
        this.JL203.setName("2");
        this.JL203.setPreferredSize(new Dimension(41, 45));
        this.JP51.add(this.JL203);
        this.JL203.setBounds(0, 0, 41, 45);
        this.JL204.setMaximumSize(new Dimension(41, 45));
        this.JL204.setMinimumSize(new Dimension(41, 45));
        this.JL204.setName("1");
        this.JL204.setPreferredSize(new Dimension(41, 45));
        this.JP51.add(this.JL204);
        this.JL204.setBounds(0, 0, 41, 45);
        this.JLDBlanco51.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco51.setName("0");
        this.JP51.add(this.JLDBlanco51);
        this.JLDBlanco51.setBounds(0, 0, 41, 45);
        this.jLabel53.setFont(new Font("Arial", 1, 12));
        this.jLabel53.setHorizontalAlignment(0);
        this.jLabel53.setText("20");
        this.JP52.setMaximumSize(new Dimension(41, 45));
        this.JP52.setMinimumSize(new Dimension(41, 45));
        this.JP52.setName("20");
        this.JP52.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.20
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP52MouseClicked(evt);
            }
        });
        this.JP52.setLayout((LayoutManager) null);
        this.JL205.setMaximumSize(new Dimension(41, 45));
        this.JL205.setMinimumSize(new Dimension(41, 45));
        this.JL205.setName("4");
        this.JL205.setPreferredSize(new Dimension(41, 45));
        this.JP52.add(this.JL205);
        this.JL205.setBounds(0, 0, 41, 45);
        this.JL206.setMaximumSize(new Dimension(41, 45));
        this.JL206.setMinimumSize(new Dimension(41, 45));
        this.JL206.setName("3");
        this.JL206.setPreferredSize(new Dimension(41, 45));
        this.JP52.add(this.JL206);
        this.JL206.setBounds(0, 0, 41, 45);
        this.JL207.setMaximumSize(new Dimension(41, 45));
        this.JL207.setMinimumSize(new Dimension(41, 45));
        this.JL207.setName("2");
        this.JL207.setPreferredSize(new Dimension(41, 45));
        this.JP52.add(this.JL207);
        this.JL207.setBounds(0, 0, 41, 45);
        this.JL208.setMaximumSize(new Dimension(41, 45));
        this.JL208.setMinimumSize(new Dimension(41, 45));
        this.JL208.setName("1");
        this.JL208.setPreferredSize(new Dimension(41, 45));
        this.JP52.add(this.JL208);
        this.JL208.setBounds(0, 0, 41, 45);
        this.JLDBlanco52.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco52.setName("0");
        this.JP52.add(this.JLDBlanco52);
        this.JLDBlanco52.setBounds(0, 0, 41, 45);
        this.jLabel54.setFont(new Font("Arial", 1, 12));
        this.jLabel54.setHorizontalAlignment(0);
        this.jLabel54.setText("21");
        this.JP53.setMaximumSize(new Dimension(41, 45));
        this.JP53.setMinimumSize(new Dimension(41, 45));
        this.JP53.setName("21");
        this.JP53.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.21
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP53MouseClicked(evt);
            }
        });
        this.JP53.setLayout((LayoutManager) null);
        this.JL209.setMaximumSize(new Dimension(41, 45));
        this.JL209.setMinimumSize(new Dimension(41, 45));
        this.JL209.setName("4");
        this.JL209.setPreferredSize(new Dimension(41, 45));
        this.JP53.add(this.JL209);
        this.JL209.setBounds(0, 0, 41, 45);
        this.JL210.setMaximumSize(new Dimension(41, 45));
        this.JL210.setMinimumSize(new Dimension(41, 45));
        this.JL210.setName("3");
        this.JL210.setPreferredSize(new Dimension(41, 45));
        this.JP53.add(this.JL210);
        this.JL210.setBounds(0, 0, 41, 45);
        this.JL211.setMaximumSize(new Dimension(41, 45));
        this.JL211.setMinimumSize(new Dimension(41, 45));
        this.JL211.setName("2");
        this.JL211.setPreferredSize(new Dimension(41, 45));
        this.JP53.add(this.JL211);
        this.JL211.setBounds(0, 0, 41, 45);
        this.JL212.setMaximumSize(new Dimension(41, 45));
        this.JL212.setMinimumSize(new Dimension(41, 45));
        this.JL212.setName("1");
        this.JL212.setPreferredSize(new Dimension(41, 45));
        this.JP53.add(this.JL212);
        this.JL212.setBounds(0, 0, 41, 45);
        this.JLDBlanco53.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco53.setName("0");
        this.JP53.add(this.JLDBlanco53);
        this.JLDBlanco53.setBounds(0, 0, 41, 45);
        this.jLabel55.setFont(new Font("Arial", 1, 12));
        this.jLabel55.setHorizontalAlignment(0);
        this.jLabel55.setText("22");
        this.JP54.setMaximumSize(new Dimension(41, 45));
        this.JP54.setMinimumSize(new Dimension(41, 45));
        this.JP54.setName("22");
        this.JP54.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.22
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP54MouseClicked(evt);
            }
        });
        this.JP54.setLayout((LayoutManager) null);
        this.JL213.setMaximumSize(new Dimension(41, 45));
        this.JL213.setMinimumSize(new Dimension(41, 45));
        this.JL213.setName("4");
        this.JL213.setPreferredSize(new Dimension(41, 45));
        this.JP54.add(this.JL213);
        this.JL213.setBounds(0, 0, 41, 45);
        this.JL214.setMaximumSize(new Dimension(41, 45));
        this.JL214.setMinimumSize(new Dimension(41, 45));
        this.JL214.setName("3");
        this.JL214.setPreferredSize(new Dimension(41, 45));
        this.JP54.add(this.JL214);
        this.JL214.setBounds(0, 0, 41, 45);
        this.JL215.setMaximumSize(new Dimension(41, 45));
        this.JL215.setMinimumSize(new Dimension(41, 45));
        this.JL215.setName("2");
        this.JL215.setPreferredSize(new Dimension(41, 45));
        this.JP54.add(this.JL215);
        this.JL215.setBounds(0, 0, 41, 45);
        this.JL216.setMaximumSize(new Dimension(41, 45));
        this.JL216.setMinimumSize(new Dimension(41, 45));
        this.JL216.setName("1");
        this.JL216.setPreferredSize(new Dimension(41, 45));
        this.JP54.add(this.JL216);
        this.JL216.setBounds(0, 0, 41, 45);
        this.JLDBlanco54.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco54.setName("0");
        this.JP54.add(this.JLDBlanco54);
        this.JLDBlanco54.setBounds(0, 0, 41, 45);
        this.jLabel56.setFont(new Font("Arial", 1, 12));
        this.jLabel56.setHorizontalAlignment(0);
        this.jLabel56.setText("23");
        this.JP55.setMaximumSize(new Dimension(41, 45));
        this.JP55.setMinimumSize(new Dimension(41, 45));
        this.JP55.setName("23");
        this.JP55.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.23
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP55MouseClicked(evt);
            }
        });
        this.JP55.setLayout((LayoutManager) null);
        this.JL217.setMaximumSize(new Dimension(41, 45));
        this.JL217.setMinimumSize(new Dimension(41, 45));
        this.JL217.setName("4");
        this.JL217.setPreferredSize(new Dimension(41, 45));
        this.JP55.add(this.JL217);
        this.JL217.setBounds(0, 0, 41, 45);
        this.JL218.setMaximumSize(new Dimension(41, 45));
        this.JL218.setMinimumSize(new Dimension(41, 45));
        this.JL218.setName("3");
        this.JL218.setPreferredSize(new Dimension(41, 45));
        this.JP55.add(this.JL218);
        this.JL218.setBounds(0, 0, 41, 45);
        this.JL219.setMaximumSize(new Dimension(41, 45));
        this.JL219.setMinimumSize(new Dimension(41, 45));
        this.JL219.setName("2");
        this.JL219.setPreferredSize(new Dimension(41, 45));
        this.JP55.add(this.JL219);
        this.JL219.setBounds(0, 0, 41, 45);
        this.JL220.setMaximumSize(new Dimension(41, 45));
        this.JL220.setMinimumSize(new Dimension(41, 45));
        this.JL220.setName("1");
        this.JL220.setPreferredSize(new Dimension(41, 45));
        this.JP55.add(this.JL220);
        this.JL220.setBounds(0, 0, 41, 45);
        this.JLDBlanco55.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco55.setName("0");
        this.JP55.add(this.JLDBlanco55);
        this.JLDBlanco55.setBounds(0, 0, 41, 45);
        this.jLabel57.setFont(new Font("Arial", 1, 12));
        this.jLabel57.setHorizontalAlignment(0);
        this.jLabel57.setText("24");
        this.JP56.setMaximumSize(new Dimension(41, 45));
        this.JP56.setMinimumSize(new Dimension(41, 45));
        this.JP56.setName("24");
        this.JP56.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.24
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP56MouseClicked(evt);
            }
        });
        this.JP56.setLayout((LayoutManager) null);
        this.JL221.setMaximumSize(new Dimension(41, 45));
        this.JL221.setMinimumSize(new Dimension(41, 45));
        this.JL221.setName("4");
        this.JL221.setPreferredSize(new Dimension(41, 45));
        this.JP56.add(this.JL221);
        this.JL221.setBounds(0, 0, 41, 45);
        this.JL222.setMaximumSize(new Dimension(41, 45));
        this.JL222.setMinimumSize(new Dimension(41, 45));
        this.JL222.setName("3");
        this.JL222.setPreferredSize(new Dimension(41, 45));
        this.JP56.add(this.JL222);
        this.JL222.setBounds(0, 0, 41, 45);
        this.JL223.setMaximumSize(new Dimension(41, 45));
        this.JL223.setMinimumSize(new Dimension(41, 45));
        this.JL223.setName("2");
        this.JL223.setPreferredSize(new Dimension(41, 45));
        this.JP56.add(this.JL223);
        this.JL223.setBounds(0, 0, 41, 45);
        this.JL224.setMaximumSize(new Dimension(41, 45));
        this.JL224.setMinimumSize(new Dimension(41, 45));
        this.JL224.setName("1");
        this.JL224.setPreferredSize(new Dimension(41, 45));
        this.JP56.add(this.JL224);
        this.JL224.setBounds(0, 0, 41, 45);
        this.JLDBlanco56.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco56.setName("0");
        this.JP56.add(this.JLDBlanco56);
        this.JLDBlanco56.setBounds(0, 0, 41, 45);
        this.jLabel58.setFont(new Font("Arial", 1, 12));
        this.jLabel58.setHorizontalAlignment(0);
        this.jLabel58.setText("25");
        this.JP57.setMaximumSize(new Dimension(41, 45));
        this.JP57.setMinimumSize(new Dimension(41, 45));
        this.JP57.setName("25");
        this.JP57.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.25
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP57MouseClicked(evt);
            }
        });
        this.JP57.setLayout((LayoutManager) null);
        this.JL225.setMaximumSize(new Dimension(41, 45));
        this.JL225.setMinimumSize(new Dimension(41, 45));
        this.JL225.setName("4");
        this.JL225.setPreferredSize(new Dimension(41, 45));
        this.JP57.add(this.JL225);
        this.JL225.setBounds(0, 0, 41, 45);
        this.JL226.setMaximumSize(new Dimension(41, 45));
        this.JL226.setMinimumSize(new Dimension(41, 45));
        this.JL226.setName("3");
        this.JL226.setPreferredSize(new Dimension(41, 45));
        this.JP57.add(this.JL226);
        this.JL226.setBounds(0, 0, 41, 45);
        this.JL227.setMaximumSize(new Dimension(41, 45));
        this.JL227.setMinimumSize(new Dimension(41, 45));
        this.JL227.setName("2");
        this.JL227.setPreferredSize(new Dimension(41, 45));
        this.JP57.add(this.JL227);
        this.JL227.setBounds(0, 0, 41, 45);
        this.JL228.setMaximumSize(new Dimension(41, 45));
        this.JL228.setMinimumSize(new Dimension(41, 45));
        this.JL228.setName("1");
        this.JL228.setPreferredSize(new Dimension(41, 45));
        this.JP57.add(this.JL228);
        this.JL228.setBounds(0, 0, 41, 45);
        this.JLDBlanco57.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco57.setName("0");
        this.JP57.add(this.JLDBlanco57);
        this.JLDBlanco57.setBounds(0, 0, 41, 45);
        this.jLabel59.setFont(new Font("Arial", 1, 12));
        this.jLabel59.setHorizontalAlignment(0);
        this.jLabel59.setText("26");
        this.JP58.setMaximumSize(new Dimension(41, 45));
        this.JP58.setMinimumSize(new Dimension(41, 45));
        this.JP58.setName("26");
        this.JP58.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.26
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP58MouseClicked(evt);
            }
        });
        this.JP58.setLayout((LayoutManager) null);
        this.JL229.setMaximumSize(new Dimension(41, 45));
        this.JL229.setMinimumSize(new Dimension(41, 45));
        this.JL229.setName("4");
        this.JL229.setPreferredSize(new Dimension(41, 45));
        this.JP58.add(this.JL229);
        this.JL229.setBounds(0, 0, 41, 45);
        this.JL230.setMaximumSize(new Dimension(41, 45));
        this.JL230.setMinimumSize(new Dimension(41, 45));
        this.JL230.setName("3");
        this.JL230.setPreferredSize(new Dimension(41, 45));
        this.JP58.add(this.JL230);
        this.JL230.setBounds(0, 0, 41, 45);
        this.JL231.setMaximumSize(new Dimension(41, 45));
        this.JL231.setMinimumSize(new Dimension(41, 45));
        this.JL231.setName("2");
        this.JL231.setPreferredSize(new Dimension(41, 45));
        this.JP58.add(this.JL231);
        this.JL231.setBounds(0, 0, 41, 45);
        this.JL232.setMaximumSize(new Dimension(41, 45));
        this.JL232.setMinimumSize(new Dimension(41, 45));
        this.JL232.setName("1");
        this.JL232.setPreferredSize(new Dimension(41, 45));
        this.JP58.add(this.JL232);
        this.JL232.setBounds(0, 0, 41, 45);
        this.JLDBlanco58.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco58.setName("0");
        this.JP58.add(this.JLDBlanco58);
        this.JLDBlanco58.setBounds(0, 0, 41, 45);
        this.jLabel60.setFont(new Font("Arial", 1, 12));
        this.jLabel60.setHorizontalAlignment(0);
        this.jLabel60.setText("27");
        this.JP59.setMaximumSize(new Dimension(41, 45));
        this.JP59.setMinimumSize(new Dimension(41, 45));
        this.JP59.setName("27");
        this.JP59.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.27
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP59MouseClicked(evt);
            }
        });
        this.JP59.setLayout((LayoutManager) null);
        this.JL233.setMaximumSize(new Dimension(41, 45));
        this.JL233.setMinimumSize(new Dimension(41, 45));
        this.JL233.setName("4");
        this.JL233.setPreferredSize(new Dimension(41, 45));
        this.JP59.add(this.JL233);
        this.JL233.setBounds(0, 0, 41, 45);
        this.JL234.setMaximumSize(new Dimension(41, 45));
        this.JL234.setMinimumSize(new Dimension(41, 45));
        this.JL234.setName("3");
        this.JL234.setPreferredSize(new Dimension(41, 45));
        this.JP59.add(this.JL234);
        this.JL234.setBounds(0, 0, 41, 45);
        this.JL235.setMaximumSize(new Dimension(41, 45));
        this.JL235.setMinimumSize(new Dimension(41, 45));
        this.JL235.setName("2");
        this.JL235.setPreferredSize(new Dimension(41, 45));
        this.JP59.add(this.JL235);
        this.JL235.setBounds(0, 0, 41, 45);
        this.JL236.setMaximumSize(new Dimension(41, 45));
        this.JL236.setMinimumSize(new Dimension(41, 45));
        this.JL236.setName("1");
        this.JL236.setPreferredSize(new Dimension(41, 45));
        this.JP59.add(this.JL236);
        this.JL236.setBounds(0, 0, 41, 45);
        this.JLDBlanco59.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco59.setName("0");
        this.JP59.add(this.JLDBlanco59);
        this.JLDBlanco59.setBounds(0, 0, 41, 45);
        this.jLabel61.setFont(new Font("Arial", 1, 12));
        this.jLabel61.setHorizontalAlignment(0);
        this.jLabel61.setText("28");
        this.JP60.setMaximumSize(new Dimension(41, 45));
        this.JP60.setMinimumSize(new Dimension(41, 45));
        this.JP60.setName("28");
        this.JP60.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.28
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP60MouseClicked(evt);
            }
        });
        this.JP60.setLayout((LayoutManager) null);
        this.JL237.setMaximumSize(new Dimension(41, 45));
        this.JL237.setMinimumSize(new Dimension(41, 45));
        this.JL237.setName("4");
        this.JL237.setPreferredSize(new Dimension(41, 45));
        this.JP60.add(this.JL237);
        this.JL237.setBounds(0, 0, 41, 45);
        this.JL238.setMaximumSize(new Dimension(41, 45));
        this.JL238.setMinimumSize(new Dimension(41, 45));
        this.JL238.setName("3");
        this.JL238.setPreferredSize(new Dimension(41, 45));
        this.JP60.add(this.JL238);
        this.JL238.setBounds(0, 0, 41, 45);
        this.JL239.setMaximumSize(new Dimension(41, 45));
        this.JL239.setMinimumSize(new Dimension(41, 45));
        this.JL239.setName("2");
        this.JL239.setPreferredSize(new Dimension(41, 45));
        this.JP60.add(this.JL239);
        this.JL239.setBounds(0, 0, 41, 45);
        this.JL240.setMaximumSize(new Dimension(41, 45));
        this.JL240.setMinimumSize(new Dimension(41, 45));
        this.JL240.setName("1");
        this.JL240.setPreferredSize(new Dimension(41, 45));
        this.JP60.add(this.JL240);
        this.JL240.setBounds(0, 0, 41, 45);
        this.JLDBlanco60.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco60.setName("0");
        this.JP60.add(this.JLDBlanco60);
        this.JLDBlanco60.setBounds(0, 0, 41, 45);
        this.jLabel62.setFont(new Font("Arial", 1, 12));
        this.jLabel62.setHorizontalAlignment(0);
        this.jLabel62.setText("29");
        this.JP61.setMaximumSize(new Dimension(41, 45));
        this.JP61.setMinimumSize(new Dimension(41, 45));
        this.JP61.setName("29");
        this.JP61.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.29
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP61MouseClicked(evt);
            }
        });
        this.JP61.setLayout((LayoutManager) null);
        this.JL241.setMaximumSize(new Dimension(41, 45));
        this.JL241.setMinimumSize(new Dimension(41, 45));
        this.JL241.setName("4");
        this.JL241.setPreferredSize(new Dimension(41, 45));
        this.JP61.add(this.JL241);
        this.JL241.setBounds(0, 0, 41, 45);
        this.JL242.setMaximumSize(new Dimension(41, 45));
        this.JL242.setMinimumSize(new Dimension(41, 45));
        this.JL242.setName("3");
        this.JL242.setPreferredSize(new Dimension(41, 45));
        this.JP61.add(this.JL242);
        this.JL242.setBounds(0, 0, 41, 45);
        this.JL243.setMaximumSize(new Dimension(41, 45));
        this.JL243.setMinimumSize(new Dimension(41, 45));
        this.JL243.setName("2");
        this.JL243.setPreferredSize(new Dimension(41, 45));
        this.JP61.add(this.JL243);
        this.JL243.setBounds(0, 0, 41, 45);
        this.JL244.setMaximumSize(new Dimension(41, 45));
        this.JL244.setMinimumSize(new Dimension(41, 45));
        this.JL244.setName("1");
        this.JL244.setPreferredSize(new Dimension(41, 45));
        this.JP61.add(this.JL244);
        this.JL244.setBounds(0, 0, 41, 45);
        this.JLDBlanco61.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco61.setName("0");
        this.JP61.add(this.JLDBlanco61);
        this.JLDBlanco61.setBounds(0, 0, 41, 45);
        this.jLabel63.setFont(new Font("Arial", 1, 12));
        this.jLabel63.setHorizontalAlignment(0);
        this.jLabel63.setText("30");
        this.JP62.setMaximumSize(new Dimension(41, 45));
        this.JP62.setMinimumSize(new Dimension(41, 45));
        this.JP62.setName("30");
        this.JP62.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.30
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP62MouseClicked(evt);
            }
        });
        this.JP62.setLayout((LayoutManager) null);
        this.JL245.setMaximumSize(new Dimension(41, 45));
        this.JL245.setMinimumSize(new Dimension(41, 45));
        this.JL245.setName("4");
        this.JL245.setPreferredSize(new Dimension(41, 45));
        this.JP62.add(this.JL245);
        this.JL245.setBounds(0, 0, 41, 45);
        this.JL246.setMaximumSize(new Dimension(41, 45));
        this.JL246.setMinimumSize(new Dimension(41, 45));
        this.JL246.setName("3");
        this.JL246.setPreferredSize(new Dimension(41, 45));
        this.JP62.add(this.JL246);
        this.JL246.setBounds(0, 0, 41, 45);
        this.JL247.setMaximumSize(new Dimension(41, 45));
        this.JL247.setMinimumSize(new Dimension(41, 45));
        this.JL247.setName("2");
        this.JL247.setPreferredSize(new Dimension(41, 45));
        this.JP62.add(this.JL247);
        this.JL247.setBounds(0, 0, 41, 45);
        this.JL248.setMaximumSize(new Dimension(41, 45));
        this.JL248.setMinimumSize(new Dimension(41, 45));
        this.JL248.setName("1");
        this.JL248.setPreferredSize(new Dimension(41, 45));
        this.JP62.add(this.JL248);
        this.JL248.setBounds(0, 0, 41, 45);
        this.JLDBlanco62.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco62.setName("0");
        this.JP62.add(this.JLDBlanco62);
        this.JLDBlanco62.setBounds(0, 0, 41, 45);
        this.jLabel64.setFont(new Font("Arial", 1, 12));
        this.jLabel64.setHorizontalAlignment(0);
        this.jLabel64.setText("31");
        this.JP63.setMaximumSize(new Dimension(41, 45));
        this.JP63.setMinimumSize(new Dimension(41, 45));
        this.JP63.setName("31");
        this.JP63.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.31
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP63MouseClicked(evt);
            }
        });
        this.JP63.setLayout((LayoutManager) null);
        this.JL249.setMaximumSize(new Dimension(41, 45));
        this.JL249.setMinimumSize(new Dimension(41, 45));
        this.JL249.setName("4");
        this.JL249.setPreferredSize(new Dimension(41, 45));
        this.JP63.add(this.JL249);
        this.JL249.setBounds(0, 0, 41, 45);
        this.JL250.setMaximumSize(new Dimension(41, 45));
        this.JL250.setMinimumSize(new Dimension(41, 45));
        this.JL250.setName("3");
        this.JL250.setPreferredSize(new Dimension(41, 45));
        this.JP63.add(this.JL250);
        this.JL250.setBounds(0, 0, 41, 45);
        this.JL251.setMaximumSize(new Dimension(41, 45));
        this.JL251.setMinimumSize(new Dimension(41, 45));
        this.JL251.setName("2");
        this.JL251.setPreferredSize(new Dimension(41, 45));
        this.JP63.add(this.JL251);
        this.JL251.setBounds(0, 0, 41, 45);
        this.JL252.setMaximumSize(new Dimension(41, 45));
        this.JL252.setMinimumSize(new Dimension(41, 45));
        this.JL252.setName("1");
        this.JL252.setPreferredSize(new Dimension(41, 45));
        this.JP63.add(this.JL252);
        this.JL252.setBounds(0, 0, 41, 45);
        this.JLDBlanco63.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco63.setName("0");
        this.JP63.add(this.JLDBlanco63);
        this.JLDBlanco63.setBounds(0, 0, 41, 45);
        this.jLabel65.setFont(new Font("Arial", 1, 12));
        this.jLabel65.setHorizontalAlignment(0);
        this.jLabel65.setText("32");
        this.JP64.setMaximumSize(new Dimension(41, 45));
        this.JP64.setMinimumSize(new Dimension(41, 45));
        this.JP64.setName("32");
        this.JP64.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaControlPlaca.32
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaControlPlaca.this.JP64MouseClicked(evt);
            }
        });
        this.JP64.setLayout((LayoutManager) null);
        this.JL253.setMaximumSize(new Dimension(41, 45));
        this.JL253.setMinimumSize(new Dimension(41, 45));
        this.JL253.setName("4");
        this.JL253.setPreferredSize(new Dimension(41, 45));
        this.JP64.add(this.JL253);
        this.JL253.setBounds(0, 0, 41, 45);
        this.JL254.setMaximumSize(new Dimension(41, 45));
        this.JL254.setMinimumSize(new Dimension(41, 45));
        this.JL254.setName("3");
        this.JL254.setPreferredSize(new Dimension(41, 45));
        this.JP64.add(this.JL254);
        this.JL254.setBounds(0, 0, 41, 45);
        this.JL255.setMaximumSize(new Dimension(41, 45));
        this.JL255.setMinimumSize(new Dimension(41, 45));
        this.JL255.setName("2");
        this.JL255.setPreferredSize(new Dimension(41, 45));
        this.JP64.add(this.JL255);
        this.JL255.setBounds(0, 0, 41, 45);
        this.JL256.setMaximumSize(new Dimension(41, 45));
        this.JL256.setMinimumSize(new Dimension(41, 45));
        this.JL256.setName("1");
        this.JL256.setPreferredSize(new Dimension(41, 45));
        this.JP64.add(this.JL256);
        this.JL256.setBounds(0, 0, 41, 45);
        this.JLDBlanco64.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco64.setName("0");
        this.JP64.add(this.JLDBlanco64);
        this.JLDBlanco64.setBounds(0, 0, 41, 45);
        GroupLayout JPImOdontogramaHistoricoLayout = new GroupLayout(this.JPImOdontogramaHistorico);
        this.JPImOdontogramaHistorico.setLayout(JPImOdontogramaHistoricoLayout);
        JPImOdontogramaHistoricoLayout.setHorizontalGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP33, -1, -1, 32767).addComponent(this.jLabel34, -1, 41, 32767)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP34, -1, -1, 32767).addComponent(this.jLabel35, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP35, -1, -1, 32767).addComponent(this.jLabel36, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP36, -1, -1, 32767).addComponent(this.jLabel37, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP37, -1, -1, 32767).addComponent(this.jLabel38, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP38, -1, -1, 32767).addComponent(this.jLabel39, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP39, -1, -1, 32767).addComponent(this.jLabel40, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP40, -1, -1, 32767).addComponent(this.jLabel41, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP41, -1, -1, 32767).addComponent(this.jLabel42, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP42, -1, -1, 32767).addComponent(this.jLabel43, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP43, -1, -1, 32767).addComponent(this.jLabel44, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP44, -1, -1, 32767).addComponent(this.jLabel45, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP45, -1, -1, 32767).addComponent(this.jLabel46, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP46, -1, -1, 32767).addComponent(this.jLabel47, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP47, -1, -1, 32767).addComponent(this.jLabel48, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP48, -1, -1, 32767).addComponent(this.jLabel49, -2, 41, -2))).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP64, -1, -1, 32767).addComponent(this.jLabel65, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP63, -1, -1, 32767).addComponent(this.jLabel64, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP62, -1, -1, 32767).addComponent(this.jLabel63, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP61, -1, -1, 32767).addComponent(this.jLabel62, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP60, -1, -1, 32767).addComponent(this.jLabel61, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP59, -1, -1, 32767).addComponent(this.jLabel60, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP58, -1, -1, 32767).addComponent(this.jLabel59, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP57, -1, -1, 32767).addComponent(this.jLabel58, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP56, -1, -1, 32767).addComponent(this.jLabel57, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP55, -1, -1, 32767).addComponent(this.jLabel56, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP54, -1, -1, 32767).addComponent(this.jLabel55, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP53, -1, -1, 32767).addComponent(this.jLabel54, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP52, -1, -1, 32767).addComponent(this.jLabel53, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP51, -1, -1, 32767).addComponent(this.jLabel52, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP50, -1, -1, 32767).addComponent(this.jLabel51, -2, 41, -2)).addGap(0, 0, 0).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP49, -1, -1, 32767).addComponent(this.jLabel50, -2, 41, -2)))).addContainerGap(18, 32767)));
        JPImOdontogramaHistoricoLayout.setVerticalGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel49).addGap(1, 1, 1).addComponent(this.JP48, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel48).addGap(1, 1, 1).addComponent(this.JP47, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel47).addGap(1, 1, 1).addComponent(this.JP46, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel46).addGap(1, 1, 1).addComponent(this.JP45, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel45).addGap(1, 1, 1).addComponent(this.JP44, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel44).addGap(1, 1, 1).addComponent(this.JP43, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel43).addGap(1, 1, 1).addComponent(this.JP42, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel42).addGap(1, 1, 1).addComponent(this.JP41, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel41).addGap(1, 1, 1).addComponent(this.JP40, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel40).addGap(1, 1, 1).addComponent(this.JP39, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel39).addGap(1, 1, 1).addComponent(this.JP38, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel38).addGap(1, 1, 1).addComponent(this.JP37, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel37).addGap(1, 1, 1).addComponent(this.JP36, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel36).addGap(1, 1, 1).addComponent(this.JP35, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel35).addGap(1, 1, 1).addComponent(this.JP34, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel34).addGap(1, 1, 1).addComponent(this.JP33, -2, 45, -2))))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel50).addGap(1, 1, 1).addComponent(this.JP49, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel51).addGap(1, 1, 1).addComponent(this.JP50, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel52).addGap(1, 1, 1).addComponent(this.JP51, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel53).addGap(1, 1, 1).addComponent(this.JP52, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel54).addGap(1, 1, 1).addComponent(this.JP53, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel55).addGap(1, 1, 1).addComponent(this.JP54, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel56).addGap(1, 1, 1).addComponent(this.JP55, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel57).addGap(1, 1, 1).addComponent(this.JP56, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel58).addGap(1, 1, 1).addComponent(this.JP57, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel59).addGap(1, 1, 1).addComponent(this.JP58, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel60).addGap(1, 1, 1).addComponent(this.JP59, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel61).addGap(1, 1, 1).addComponent(this.JP60, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel62).addGap(1, 1, 1).addComponent(this.JP61, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel63).addGap(1, 1, 1).addComponent(this.JP62, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel64).addGap(1, 1, 1).addComponent(this.JP63, -2, 45, -2)).addGroup(JPImOdontogramaHistoricoLayout.createSequentialGroup().addComponent(this.jLabel65).addGap(1, 1, 1).addComponent(this.JP64, -2, 45, -2))))).addContainerGap(30, 32767)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JPImOdontogramaHistorico, -1, -1, 32767).addGap(2, 2, 2)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JPImOdontogramaHistorico, -2, -1, -2).addGap(2, 2, 2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP33MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP34MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP35MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP36MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP37MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP38MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP39MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP40MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP41MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP42MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP43MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP44MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP45MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP46MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP47MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP48MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP49MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP50MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP51MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP52MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP53MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP54MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP55MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP56MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP57MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP58MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP59MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP60MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP61MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP62MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP63MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP64MouseClicked(MouseEvent evt) {
    }
}
