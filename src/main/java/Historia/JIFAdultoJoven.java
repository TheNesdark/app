package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFAdultoJoven.class */
public class JIFAdultoJoven extends JPanel {
    private int x1 = 0;
    private int x2 = 0;
    private int x3 = 0;
    private int x4 = 0;
    private int x5 = 0;
    private int x6 = 0;
    private int x7 = 0;
    private int x8 = 0;
    private int xTnGen = 0;
    private int xTnPub = 0;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private ButtonGroup JBGDeporte;
    private ButtonGroup JBGEnsenanza;
    private ButtonGroup JBGFemeninoP;
    private ButtonGroup JBGFemeninoS;
    private ButtonGroup JBGHobi;
    private ButtonGroup JBGMasculinoG;
    private ButtonGroup JBGMasculinoP;
    private ButtonGroup JBGPlani;
    private ButtonGroup JBGRelSex;
    private ButtonGroup JBGSalMental;
    private ButtonGroup JBGSicoActiva;
    private ButtonGroup JBGTrastorno;
    private JButton JBGrabar;
    private JLabel JLHombres;
    private JLabel JLMujeres;
    private JPanel JPHistorico;
    private JPanel JPHombres;
    private JPanel JPMujeres;
    private JRadioButton JRBG1;
    private JRadioButton JRBG2;
    private JRadioButton JRBG3;
    private JRadioButton JRBG4;
    private JRadioButton JRBG5;
    private JRadioButton JRBNo1;
    private JRadioButton JRBNo2;
    private JRadioButton JRBNo3;
    private JRadioButton JRBNo4;
    private JRadioButton JRBNo5;
    private JRadioButton JRBNo6;
    private JRadioButton JRBNo7;
    private JRadioButton JRBNo8;
    private JRadioButton JRBP1;
    private JRadioButton JRBP2;
    private JRadioButton JRBP3;
    private JRadioButton JRBP4;
    private JRadioButton JRBP5;
    private JRadioButton JRBPF1;
    private JRadioButton JRBPF2;
    private JRadioButton JRBPF3;
    private JRadioButton JRBPF4;
    private JRadioButton JRBPF5;
    private JRadioButton JRBPS5;
    private JRadioButton JRBS1;
    private JRadioButton JRBS2;
    private JRadioButton JRBS3;
    private JRadioButton JRBS4;
    private JRadioButton JRBSi1;
    private JRadioButton JRBSi2;
    private JRadioButton JRBSi3;
    private JRadioButton JRBSi4;
    private JRadioButton JRBSi5;
    private JRadioButton JRBSi6;
    private JRadioButton JRBSi7;
    private JRadioButton JRBSi8;
    private JScrollPane JSCPaneH;
    private JTextArea JTFArea;
    private JTable JTHistorico;
    private JTabbedPane JTPDatosG;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JTextField jTextField6;
    private JTextField jTextField7;
    private JTextField jTextField8;

    public JIFAdultoJoven() {
        initComponents();
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo().equals("M")) {
            this.JTPDatosG.remove(2);
        } else {
            this.JTPDatosG.remove(1);
        }
        xExisteEvaluacion();
        mBuscaHistoricoFunc();
    }

    /* JADX WARN: Type inference failed for: r3v181, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGMasculinoG = new ButtonGroup();
        this.JBGMasculinoP = new ButtonGroup();
        this.JBGFemeninoS = new ButtonGroup();
        this.JBGFemeninoP = new ButtonGroup();
        this.JBGSicoActiva = new ButtonGroup();
        this.JBGRelSex = new ButtonGroup();
        this.JBGPlani = new ButtonGroup();
        this.JBGSalMental = new ButtonGroup();
        this.JBGTrastorno = new ButtonGroup();
        this.JBGDeporte = new ButtonGroup();
        this.JBGHobi = new ButtonGroup();
        this.JBGEnsenanza = new ButtonGroup();
        this.JTPDatosG = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.jPanel2 = new JPanel();
        this.jLabel1 = new JLabel();
        this.JRBSi1 = new JRadioButton();
        this.JRBNo1 = new JRadioButton();
        this.jTextField1 = new JTextField();
        this.jLabel2 = new JLabel();
        this.JRBSi2 = new JRadioButton();
        this.JRBNo2 = new JRadioButton();
        this.jTextField2 = new JTextField();
        this.jLabel3 = new JLabel();
        this.JRBSi3 = new JRadioButton();
        this.JRBNo3 = new JRadioButton();
        this.jTextField3 = new JTextField();
        this.jLabel4 = new JLabel();
        this.JRBSi4 = new JRadioButton();
        this.JRBNo4 = new JRadioButton();
        this.jTextField4 = new JTextField();
        this.jLabel5 = new JLabel();
        this.JRBSi5 = new JRadioButton();
        this.JRBNo5 = new JRadioButton();
        this.jTextField5 = new JTextField();
        this.jLabel6 = new JLabel();
        this.JRBSi6 = new JRadioButton();
        this.JRBNo6 = new JRadioButton();
        this.jTextField6 = new JTextField();
        this.jLabel7 = new JLabel();
        this.JRBSi7 = new JRadioButton();
        this.JRBNo7 = new JRadioButton();
        this.jTextField7 = new JTextField();
        this.jLabel8 = new JLabel();
        this.JRBSi8 = new JRadioButton();
        this.JRBNo8 = new JRadioButton();
        this.jTextField8 = new JTextField();
        this.JBGrabar = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTFArea = new JTextArea();
        this.JPHombres = new JPanel();
        this.JRBG1 = new JRadioButton();
        this.JRBG2 = new JRadioButton();
        this.JRBG3 = new JRadioButton();
        this.JRBG4 = new JRadioButton();
        this.JRBG5 = new JRadioButton();
        this.JRBP1 = new JRadioButton();
        this.JRBP2 = new JRadioButton();
        this.JRBP3 = new JRadioButton();
        this.JRBP4 = new JRadioButton();
        this.JRBP5 = new JRadioButton();
        this.JLHombres = new JLabel();
        this.JPMujeres = new JPanel();
        this.JRBS1 = new JRadioButton();
        this.JRBS2 = new JRadioButton();
        this.JRBS3 = new JRadioButton();
        this.JRBS4 = new JRadioButton();
        this.JRBPS5 = new JRadioButton();
        this.JRBPF1 = new JRadioButton();
        this.JRBPF2 = new JRadioButton();
        this.JRBPF3 = new JRadioButton();
        this.JRBPF4 = new JRadioButton();
        this.JRBPF5 = new JRadioButton();
        this.JLMujeres = new JLabel();
        this.JPHistorico = new JPanel();
        this.JSCPaneH = new JScrollPane();
        this.JTHistorico = new JTable();
        setName("jifadultojoven");
        this.JTPDatosG.setForeground(Color.red);
        this.JTPDatosG.setFont(new Font("Arial", 1, 14));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("<html><p align=\"justify\">Consumo de sustancias psicoactivas: (cocaina, marihuana, heroína, bazuco, anfetaminas)</p></html>");
        this.JBGSicoActiva.add(this.JRBSi1);
        this.JRBSi1.setFont(new Font("Arial", 1, 12));
        this.JRBSi1.setText("SI");
        this.JRBSi1.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.1
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBSi1ActionPerformed(evt);
            }
        });
        this.JBGSicoActiva.add(this.JRBNo1);
        this.JRBNo1.setFont(new Font("Arial", 1, 12));
        this.JRBNo1.setSelected(true);
        this.JRBNo1.setText("NO");
        this.JRBNo1.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.2
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBNo1ActionPerformed(evt);
            }
        });
        this.jTextField1.setFont(new Font("Arial", 0, 11));
        this.jTextField1.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuales?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText("Inicio de relaciones sexuales:");
        this.JBGRelSex.add(this.JRBSi2);
        this.JRBSi2.setFont(new Font("Arial", 1, 12));
        this.JRBSi2.setText("SI");
        this.JRBSi2.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.3
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBSi2ActionPerformed(evt);
            }
        });
        this.JBGRelSex.add(this.JRBNo2);
        this.JRBNo2.setFont(new Font("Arial", 1, 12));
        this.JRBNo2.setSelected(true);
        this.JRBNo2.setText("NO");
        this.JRBNo2.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.4
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBNo2ActionPerformed(evt);
            }
        });
        this.jTextField2.setFont(new Font("Arial", 0, 11));
        this.jTextField2.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad de Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setText("Planificación familiar:");
        this.JBGPlani.add(this.JRBSi3);
        this.JRBSi3.setFont(new Font("Arial", 1, 12));
        this.JRBSi3.setText("SI");
        this.JRBSi3.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.5
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBSi3ActionPerformed(evt);
            }
        });
        this.JBGPlani.add(this.JRBNo3);
        this.JRBNo3.setFont(new Font("Arial", 1, 12));
        this.JRBNo3.setSelected(true);
        this.JRBNo3.setText("NO");
        this.JRBNo3.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.6
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBNo3ActionPerformed(evt);
            }
        });
        this.jTextField3.setFont(new Font("Arial", 0, 11));
        this.jTextField3.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuales Métodos de planificación?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setText("<html><p>Salud mental (depresión, intento de suicidio):</p></html>");
        this.JBGSalMental.add(this.JRBSi4);
        this.JRBSi4.setFont(new Font("Arial", 1, 12));
        this.JRBSi4.setText("SI");
        this.JRBSi4.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.7
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBSi4ActionPerformed(evt);
            }
        });
        this.JBGSalMental.add(this.JRBNo4);
        this.JRBNo4.setFont(new Font("Arial", 1, 12));
        this.JRBNo4.setSelected(true);
        this.JRBNo4.setText("NO");
        this.JRBNo4.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.8
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBNo4ActionPerformed(evt);
            }
        });
        this.jTextField4.setFont(new Font("Arial", 0, 11));
        this.jTextField4.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuales enfermedades?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setText("<html><p>Trastornos alimenticios (anorexia, bulimia, otros):</p></html>");
        this.JBGTrastorno.add(this.JRBSi5);
        this.JRBSi5.setFont(new Font("Arial", 1, 12));
        this.JRBSi5.setText("SI");
        this.JRBSi5.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.9
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBSi5ActionPerformed(evt);
            }
        });
        this.JBGTrastorno.add(this.JRBNo5);
        this.JRBNo5.setFont(new Font("Arial", 1, 12));
        this.JRBNo5.setSelected(true);
        this.JRBNo5.setText("NO");
        this.JRBNo5.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.10
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBNo5ActionPerformed(evt);
            }
        });
        this.jTextField5.setFont(new Font("Arial", 0, 11));
        this.jTextField5.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuales Trastornos?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setText("<html><p>Actividades Deportivas:</p></html>");
        this.JBGDeporte.add(this.JRBSi6);
        this.JRBSi6.setFont(new Font("Arial", 1, 12));
        this.JRBSi6.setText("SI");
        this.JRBSi6.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.11
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBSi6ActionPerformed(evt);
            }
        });
        this.JBGDeporte.add(this.JRBNo6);
        this.JRBNo6.setFont(new Font("Arial", 1, 12));
        this.JRBNo6.setSelected(true);
        this.JRBNo6.setText("NO");
        this.JRBNo6.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.12
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBNo6ActionPerformed(evt);
            }
        });
        this.jTextField6.setFont(new Font("Arial", 0, 11));
        this.jTextField6.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuales Actividades?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setText("<html><p>Hobbies:</p></html>");
        this.JBGHobi.add(this.JRBSi7);
        this.JRBSi7.setFont(new Font("Arial", 1, 12));
        this.JRBSi7.setText("SI");
        this.JRBSi7.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.13
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBSi7ActionPerformed(evt);
            }
        });
        this.JBGHobi.add(this.JRBNo7);
        this.JRBNo7.setFont(new Font("Arial", 1, 12));
        this.JRBNo7.setSelected(true);
        this.JRBNo7.setText("NO");
        this.JRBNo7.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.14
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBNo7ActionPerformed(evt);
            }
        });
        this.jTextField7.setFont(new Font("Arial", 0, 11));
        this.jTextField7.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuales Hobbies?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setText("<html><p>Enseñanza de autoexamen de senos y testículos</p></html>");
        this.JBGEnsenanza.add(this.JRBSi8);
        this.JRBSi8.setFont(new Font("Arial", 1, 12));
        this.JRBSi8.setText("SI");
        this.JRBSi8.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.15
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBSi8ActionPerformed(evt);
            }
        });
        this.JBGEnsenanza.add(this.JRBNo8);
        this.JRBNo8.setFont(new Font("Arial", 1, 12));
        this.JRBNo8.setSelected(true);
        this.JRBNo8.setText("NO");
        this.JRBNo8.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.16
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBNo8ActionPerformed(evt);
            }
        });
        this.jTextField8.setFont(new Font("Arial", 0, 11));
        this.jTextField8.setBorder(BorderFactory.createTitledBorder((Border) null, "Enseñanza", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jLabel5, -2, 221, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSi5).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNo5).addGap(27, 27, 27).addComponent(this.jTextField5, -1, 364, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jLabel4, -2, 221, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSi4).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNo4).addGap(27, 27, 27).addComponent(this.jTextField4, -1, 364, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel1, -2, 221, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSi1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNo1).addGap(27, 27, 27).addComponent(this.jTextField1)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel2, -2, 221, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSi2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNo2).addGap(27, 27, 27).addComponent(this.jTextField2, -1, 364, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jLabel3, -2, 221, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSi3).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNo3).addGap(27, 27, 27).addComponent(this.jTextField3, -1, 364, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jLabel6, -2, 221, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSi6).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNo6).addGap(27, 27, 27).addComponent(this.jTextField6, -1, 364, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jLabel7, -2, 221, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSi7).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNo7).addGap(27, 27, 27).addComponent(this.jTextField7, -1, 364, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jLabel8, -2, 221, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSi8).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNo8).addGap(27, 27, 27).addComponent(this.jTextField8, -1, 364, 32767))).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextField1, -2, -1, -2).addComponent(this.JRBSi1).addComponent(this.JRBNo1)).addComponent(this.jLabel1, -2, 40, -2)).addGap(5, 5, 5).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2, GroupLayout.Alignment.TRAILING, -2, 40, -2).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextField2, -2, -1, -2).addComponent(this.JRBSi2).addComponent(this.JRBNo2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextField3, -2, -1, -2).addComponent(this.jLabel3).addComponent(this.JRBSi3).addComponent(this.JRBNo3)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextField4, -2, -1, -2).addComponent(this.JRBSi4).addComponent(this.JRBNo4))).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel4, -2, -1, -2))).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(6, 6, 6).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextField5, -2, -1, -2).addComponent(this.JRBSi5).addComponent(this.JRBNo5)).addGap(6, 6, 6)).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextField6, -2, -1, -2).addComponent(this.JRBSi6).addComponent(this.JRBNo6).addComponent(this.jLabel6, -2, -1, -2)).addGap(5, 5, 5).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextField7, -2, -1, -2).addComponent(this.JRBSi7).addComponent(this.JRBNo7).addComponent(this.jLabel7, -2, -1, -2)).addGap(5, 5, 5).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel8, GroupLayout.Alignment.TRAILING, -2, 40, -2).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextField8, -2, -1, -2).addComponent(this.JRBSi8).addComponent(this.JRBNo8)))));
        this.jLabel1.getAccessibleContext().setAccessibleName("<html><p align=\"justify\">Consumo de sustancias psicoactivas: (cocaina, marihuana, heroína, bazuco, anfetaminas)</p>");
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabar.setText("Grabar");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.17
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JBGrabarActionPerformed(evt);
            }
        });
        this.JTFArea.setColumns(1);
        this.JTFArea.setFont(new Font("Arial", 0, 13));
        this.JTFArea.setLineWrap(true);
        this.JTFArea.setRows(1);
        this.JTFArea.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTFArea);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.JBGrabar, -1, -1, 32767).addComponent(this.jScrollPane1)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 149, -2).addGap(10, 10, 10).addComponent(this.JBGrabar).addContainerGap()));
        this.JTPDatosG.addTab("ANTECEDENTES", this.jPanel1);
        this.JPHombres.setLayout((LayoutManager) null);
        this.JRBG1.setBackground(Color.red);
        this.JBGMasculinoG.add(this.JRBG1);
        this.JRBG1.setSelected(true);
        this.JRBG1.setName("1");
        this.JRBG1.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.18
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBG1ActionPerformed(evt);
            }
        });
        this.JPHombres.add(this.JRBG1);
        this.JRBG1.setBounds(320, 80, 20, 25);
        this.JRBG2.setBackground(Color.red);
        this.JBGMasculinoG.add(this.JRBG2);
        this.JRBG2.setName("2");
        this.JRBG2.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.19
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBG2ActionPerformed(evt);
            }
        });
        this.JPHombres.add(this.JRBG2);
        this.JRBG2.setBounds(320, 200, 20, 25);
        this.JRBG3.setBackground(Color.red);
        this.JBGMasculinoG.add(this.JRBG3);
        this.JRBG3.setName("3");
        this.JRBG3.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.20
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBG3ActionPerformed(evt);
            }
        });
        this.JPHombres.add(this.JRBG3);
        this.JRBG3.setBounds(320, 310, 20, 25);
        this.JRBG4.setBackground(Color.red);
        this.JBGMasculinoG.add(this.JRBG4);
        this.JRBG4.setName("4");
        this.JRBG4.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.21
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBG4ActionPerformed(evt);
            }
        });
        this.JPHombres.add(this.JRBG4);
        this.JRBG4.setBounds(320, 430, 20, 25);
        this.JRBG5.setBackground(Color.red);
        this.JBGMasculinoG.add(this.JRBG5);
        this.JRBG5.setName("5");
        this.JRBG5.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.22
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBG5ActionPerformed(evt);
            }
        });
        this.JPHombres.add(this.JRBG5);
        this.JRBG5.setBounds(320, 550, 20, 25);
        this.JRBP1.setBackground(Color.red);
        this.JBGMasculinoP.add(this.JRBP1);
        this.JRBP1.setSelected(true);
        this.JRBP1.setName("6");
        this.JRBP1.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.23
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBP1ActionPerformed(evt);
            }
        });
        this.JPHombres.add(this.JRBP1);
        this.JRBP1.setBounds(670, 80, 20, 25);
        this.JRBP2.setBackground(Color.red);
        this.JBGMasculinoP.add(this.JRBP2);
        this.JRBP2.setName("7");
        this.JRBP2.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.24
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBP2ActionPerformed(evt);
            }
        });
        this.JPHombres.add(this.JRBP2);
        this.JRBP2.setBounds(670, 200, 20, 25);
        this.JRBP3.setBackground(Color.red);
        this.JBGMasculinoP.add(this.JRBP3);
        this.JRBP3.setName("8");
        this.JRBP3.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.25
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBP3ActionPerformed(evt);
            }
        });
        this.JPHombres.add(this.JRBP3);
        this.JRBP3.setBounds(670, 310, 20, 25);
        this.JRBP4.setBackground(Color.red);
        this.JBGMasculinoP.add(this.JRBP4);
        this.JRBP4.setName("9");
        this.JRBP4.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.26
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBP4ActionPerformed(evt);
            }
        });
        this.JPHombres.add(this.JRBP4);
        this.JRBP4.setBounds(670, 430, 20, 25);
        this.JRBP5.setBackground(Color.red);
        this.JBGMasculinoP.add(this.JRBP5);
        this.JRBP5.setName("10");
        this.JRBP5.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.27
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBP5ActionPerformed(evt);
            }
        });
        this.JPHombres.add(this.JRBP5);
        this.JRBP5.setBounds(670, 550, 20, 25);
        this.JLHombres.setIcon(new ImageIcon(getClass().getResource("/Imagenes/TannerMasc.jpg")));
        this.JPHombres.add(this.JLHombres);
        this.JLHombres.setBounds(10, 3, 690, 626);
        this.JTPDatosG.addTab("DESARROLLO PUBERAL EN VARONES", this.JPHombres);
        this.JPMujeres.setLayout((LayoutManager) null);
        this.JRBS1.setBackground(Color.red);
        this.JBGFemeninoS.add(this.JRBS1);
        this.JRBS1.setSelected(true);
        this.JRBS1.setName("6");
        this.JRBS1.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.28
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBS1ActionPerformed(evt);
            }
        });
        this.JPMujeres.add(this.JRBS1);
        this.JRBS1.setBounds(330, 100, 20, 25);
        this.JRBS2.setBackground(Color.red);
        this.JBGFemeninoS.add(this.JRBS2);
        this.JRBS2.setName("7");
        this.JRBS2.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.29
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBS2ActionPerformed(evt);
            }
        });
        this.JPMujeres.add(this.JRBS2);
        this.JRBS2.setBounds(330, 200, 20, 25);
        this.JRBS3.setBackground(Color.red);
        this.JBGFemeninoS.add(this.JRBS3);
        this.JRBS3.setName("8");
        this.JRBS3.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.30
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBS3ActionPerformed(evt);
            }
        });
        this.JPMujeres.add(this.JRBS3);
        this.JRBS3.setBounds(330, 300, 20, 25);
        this.JRBS4.setBackground(Color.red);
        this.JBGFemeninoS.add(this.JRBS4);
        this.JRBS4.setName("9");
        this.JRBS4.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.31
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBS4ActionPerformed(evt);
            }
        });
        this.JPMujeres.add(this.JRBS4);
        this.JRBS4.setBounds(330, 410, 20, 25);
        this.JRBPS5.setBackground(Color.red);
        this.JBGFemeninoS.add(this.JRBPS5);
        this.JRBPS5.setName("10");
        this.JRBPS5.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.32
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBPS5ActionPerformed(evt);
            }
        });
        this.JPMujeres.add(this.JRBPS5);
        this.JRBPS5.setBounds(330, 530, 20, 25);
        this.JRBPF1.setBackground(Color.red);
        this.JBGFemeninoP.add(this.JRBPF1);
        this.JRBPF1.setSelected(true);
        this.JRBPF1.setName("1");
        this.JRBPF1.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.33
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBPF1ActionPerformed(evt);
            }
        });
        this.JPMujeres.add(this.JRBPF1);
        this.JRBPF1.setBounds(660, 110, 20, 25);
        this.JRBPF2.setBackground(Color.red);
        this.JBGFemeninoP.add(this.JRBPF2);
        this.JRBPF2.setName("2");
        this.JRBPF2.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.34
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBPF2ActionPerformed(evt);
            }
        });
        this.JPMujeres.add(this.JRBPF2);
        this.JRBPF2.setBounds(660, 210, 20, 25);
        this.JRBPF3.setBackground(Color.red);
        this.JBGFemeninoP.add(this.JRBPF3);
        this.JRBPF3.setName("3");
        this.JRBPF3.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.35
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBPF3ActionPerformed(evt);
            }
        });
        this.JPMujeres.add(this.JRBPF3);
        this.JRBPF3.setBounds(660, 310, 20, 25);
        this.JRBPF4.setBackground(Color.red);
        this.JBGFemeninoP.add(this.JRBPF4);
        this.JRBPF4.setName("4");
        this.JRBPF4.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.36
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBPF4ActionPerformed(evt);
            }
        });
        this.JPMujeres.add(this.JRBPF4);
        this.JRBPF4.setBounds(660, 420, 20, 25);
        this.JRBPF5.setBackground(Color.red);
        this.JBGFemeninoP.add(this.JRBPF5);
        this.JRBPF5.setName("5");
        this.JRBPF5.addActionListener(new ActionListener() { // from class: Historia.JIFAdultoJoven.37
            public void actionPerformed(ActionEvent evt) {
                JIFAdultoJoven.this.JRBPF5ActionPerformed(evt);
            }
        });
        this.JPMujeres.add(this.JRBPF5);
        this.JRBPF5.setBounds(660, 540, 20, 25);
        this.JLMujeres.setIcon(new ImageIcon(getClass().getResource("/Imagenes/TannerFem.jpg")));
        this.JPMujeres.add(this.JLMujeres);
        this.JLMujeres.setBounds(10, 3, 680, 620);
        this.JTPDatosG.addTab("DESARROLLO PUBERAL EN MUJERES", this.JPMujeres);
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistorico.setSelectionBackground(Color.white);
        this.JTHistorico.setSelectionForeground(Color.red);
        this.JSCPaneH.setViewportView(this.JTHistorico);
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSCPaneH, -1, 726, 32767).addContainerGap()));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSCPaneH, -1, 609, 32767).addContainerGap()));
        this.JTPDatosG.addTab("HISTÓRICO", this.JPHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosG).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatosG));
    }

    private void xExisteEvaluacion() {
        String sql = "SELECT  `Id`, Observacion  FROM  `h_aj_tanner_h` WHERE (`IdAtencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'  AND `Estado`=1)";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JBGrabar.setEnabled(false);
                this.JTFArea.setText(xrs.getString("Observacion"));
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAdultoJoven.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSi1ActionPerformed(ActionEvent evt) {
        this.x1 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNo1ActionPerformed(ActionEvent evt) {
        this.x1 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSi2ActionPerformed(ActionEvent evt) {
        this.x2 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNo2ActionPerformed(ActionEvent evt) {
        this.x2 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSi3ActionPerformed(ActionEvent evt) {
        this.x3 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNo3ActionPerformed(ActionEvent evt) {
        this.x3 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSi4ActionPerformed(ActionEvent evt) {
        this.x4 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNo4ActionPerformed(ActionEvent evt) {
        this.x4 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSi5ActionPerformed(ActionEvent evt) {
        this.x5 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNo5ActionPerformed(ActionEvent evt) {
        this.x5 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSi6ActionPerformed(ActionEvent evt) {
        this.x6 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNo6ActionPerformed(ActionEvent evt) {
        this.x6 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSi7ActionPerformed(ActionEvent evt) {
        this.x7 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNo7ActionPerformed(ActionEvent evt) {
        this.x7 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSi8ActionPerformed(ActionEvent evt) {
        this.x8 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNo8ActionPerformed(ActionEvent evt) {
        this.x8 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBG1ActionPerformed(ActionEvent evt) {
        xTannerGen(Integer.parseInt(this.JRBG1.getName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBG2ActionPerformed(ActionEvent evt) {
        xTannerGen(Integer.parseInt(this.JRBG2.getName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBG3ActionPerformed(ActionEvent evt) {
        xTannerGen(Integer.parseInt(this.JRBG3.getName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBG4ActionPerformed(ActionEvent evt) {
        xTannerGen(Integer.parseInt(this.JRBG4.getName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBG5ActionPerformed(ActionEvent evt) {
        xTannerGen(Integer.parseInt(this.JRBG5.getName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBS1ActionPerformed(ActionEvent evt) {
        xTannerGen(Integer.parseInt(this.JRBS1.getName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBS2ActionPerformed(ActionEvent evt) {
        xTannerGen(Integer.parseInt(this.JRBS2.getName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBS3ActionPerformed(ActionEvent evt) {
        xTannerGen(Integer.parseInt(this.JRBS3.getName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBS4ActionPerformed(ActionEvent evt) {
        xTannerGen(Integer.parseInt(this.JRBS4.getName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPS5ActionPerformed(ActionEvent evt) {
        xTannerGen(Integer.parseInt(this.JRBPS5.getName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBP1ActionPerformed(ActionEvent evt) {
        this.xTnPub = Integer.parseInt(this.JRBP1.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBP2ActionPerformed(ActionEvent evt) {
        this.xTnPub = Integer.parseInt(this.JRBP2.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBP3ActionPerformed(ActionEvent evt) {
        this.xTnPub = Integer.parseInt(this.JRBP3.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBP4ActionPerformed(ActionEvent evt) {
        this.xTnPub = Integer.parseInt(this.JRBP4.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBP5ActionPerformed(ActionEvent evt) {
        this.xTnPub = Integer.parseInt(this.JRBP5.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPF1ActionPerformed(ActionEvent evt) {
        this.xTnPub = Integer.parseInt(this.JRBPF1.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPF2ActionPerformed(ActionEvent evt) {
        this.xTnPub = Integer.parseInt(this.JRBPF2.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPF3ActionPerformed(ActionEvent evt) {
        this.xTnPub = Integer.parseInt(this.JRBPF3.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPF4ActionPerformed(ActionEvent evt) {
        this.xTnPub = Integer.parseInt(this.JRBPF4.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPF5ActionPerformed(ActionEvent evt) {
        this.xTnPub = Integer.parseInt(this.JRBPF5.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    private void xTannerGen(int x) {
        this.xTnGen = x;
    }

    public void mGrabar() {
        if (this.xTnGen != 0) {
            if (this.xTnPub != 0) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "Verificar", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    String sql = "INSERT INTO  `h_aj_tanner_h` (`FechaR`,`IdAtencion`,`IdUsuario`,`IdTannerGen`,`IdTannerPub`,`Observacion`,`Sustancias`,`CualesSust`,`RelSex`,\n             `EdadRel`,`PlanFliar`,`MetodosPlan`,`SMental`,`Enfermedades`,`Trastornos`,`CualesTras`,`ActDeportivas`,`CualesAct`,\n             `Hobbie`,`CualesHob`,`Ensenanza`,`DEnsenanza`,IdProfesional,IdEspecialidad,`UsuarioS`)\n VALUES ( '" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + this.xTnGen + "','" + this.xTnPub + "','" + this.JTFArea.getText() + "','" + this.x1 + "','" + this.jTextField1.getText() + "',\n        '" + this.x2 + "','" + this.jTextField2.getText() + "','" + this.x3 + "','" + this.jTextField3.getText() + "','" + this.x4 + "','" + this.jTextField4.getText() + "','" + this.x5 + "','" + this.jTextField5.getText() + "','" + this.x6 + "',\n        '" + this.jTextField6.getText() + "','" + this.x7 + "','" + this.jTextField7.getText() + "','" + this.x8 + "','" + this.jTextField8.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                    this.xct.ejecutarSQL(sql);
                    this.xct.cerrarConexionBd();
                    this.JBGrabar.setEnabled(false);
                    mBuscaHistoricoFunc();
                    this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Opción en Desarrollo del vello pubiano", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTPDatosG.setSelectedIndex(1);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Opción en Desarrollo Genital", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTPDatosG.setSelectedIndex(1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHF() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Observación", "Profesional", "Especialidad"}) { // from class: Historia.JIFAdultoJoven.38
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(7);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(350);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(80);
    }

    private void mBuscaHistoricoFunc() {
        mCrearModeloHF();
        String sql = "SELECT `h_aj_tanner_h`.`FechaR`, `h_aj_tanner_h`.`Observacion`, `profesional1`.`NProfesional`, `profesional1`.`Especialidad`\n FROM `h_aj_tanner_h`INNER JOIN `profesional1` ON (`h_aj_tanner_h`.`IdProfesional` = `profesional1`.`Id_Persona`) AND (`h_aj_tanner_h`.`IdEspecialidad` = `profesional1`.`IdEspecialidad`)\n WHERE (`h_aj_tanner_h`.`Estado` =1 AND `h_aj_tanner_h`.`IdUsuario`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "');";
        ResultSet xrs = this.xct.traerRs(sql);
        this.xmt.mEstablecerTextEditor(this.JTHistorico, 1);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAdultoMayor.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
