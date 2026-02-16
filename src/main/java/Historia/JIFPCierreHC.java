package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Email;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFPCierreHC.class */
public class JIFPCierreHC extends JInternalFrame {
    private int xp1 = 0;
    private int xp2 = 0;
    private int xp3 = 0;
    private int xp4 = 0;
    private int xp5 = 0;
    private int xp6 = -1;
    private int xp7 = -1;
    private int xp8 = 0;
    private int xp9 = 0;
    private int xp10 = 0;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private clasesHistoriaCE xclase;
    private JPAConclusion xjpconclusion;
    private ButtonGroup JBGP1;
    private ButtonGroup JBGP10;
    private ButtonGroup JBGP2;
    private ButtonGroup JBGP3;
    private ButtonGroup JBGP4;
    private ButtonGroup JBGP5;
    private ButtonGroup JBGP6;
    private ButtonGroup JBGP7;
    private ButtonGroup JBGP8;
    private ButtonGroup JBGP9;
    private JButton JBTAceptar;
    private JButton JBTSalir;
    private JCheckBox JCHInteresSO;
    private JLabel JLBNo;
    private JLabel JLBSi;
    private JPanel JPIDatosG;
    private JPanel JPIPreguntas;
    private JRadioButton JRBNoP1;
    private JRadioButton JRBNoP2;
    private JRadioButton JRBNoP3;
    private JRadioButton JRBNoP4;
    private JRadioButton JRBNoP5;
    private JRadioButton JRBNoP6;
    private JRadioButton JRBNoP7;
    private JRadioButton JRBNoP8;
    private JRadioButton JRBSiP1;
    private JRadioButton JRBSiP2;
    private JRadioButton JRBSiP3;
    private JRadioButton JRBSiP4;
    private JRadioButton JRBSiP5;
    private JRadioButton JRBSiP6;
    private JRadioButton JRBSiP7;
    private JRadioButton JRBSiP8;
    private JTextPane JTPP1;
    private JTextPane JTPP2;
    private JTextPane JTPP3;
    private JTextPane JTPP4;
    private JTextPane JTPP5;
    private JTextPane JTPP6;
    private JTextPane JTPP7;
    private JTextPane JTPP8;
    private JTabbedPane JTPpyp;
    private JLabel jLabel1;

    public JIFPCierreHC(JPAConclusion xjpconclusion, clasesHistoriaCE xclase) {
        try {
            initComponents();
            this.xjpconclusion = xjpconclusion;
            this.xclase = xclase;
            String xsql = "SELECT  Ip4 FROM h_atencion WHERE (Id ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
            ResultSet rs = this.xconsultasbd.traerRs(xsql);
            if (rs.next()) {
                if (rs.getInt(1) == 1) {
                    this.JRBSiP4.setSelected(true);
                } else {
                    this.JRBNoP4.setSelected(true);
                }
            }
            rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFPCierreHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void initComponents() {
        this.JBGP1 = new ButtonGroup();
        this.JBGP2 = new ButtonGroup();
        this.JBGP3 = new ButtonGroup();
        this.JBGP4 = new ButtonGroup();
        this.JBGP5 = new ButtonGroup();
        this.JBGP6 = new ButtonGroup();
        this.JBGP7 = new ButtonGroup();
        this.JBGP8 = new ButtonGroup();
        this.JBGP9 = new ButtonGroup();
        this.JBGP10 = new ButtonGroup();
        this.JPIPreguntas = new JPanel();
        this.JTPP2 = new JTextPane();
        this.JTPP1 = new JTextPane();
        this.JTPP3 = new JTextPane();
        this.JLBSi = new JLabel();
        this.JLBNo = new JLabel();
        this.JRBSiP1 = new JRadioButton();
        this.JRBNoP1 = new JRadioButton();
        this.JRBSiP2 = new JRadioButton();
        this.JRBNoP2 = new JRadioButton();
        this.JRBSiP3 = new JRadioButton();
        this.JRBNoP3 = new JRadioButton();
        this.JTPP4 = new JTextPane();
        this.JRBSiP4 = new JRadioButton();
        this.JRBNoP4 = new JRadioButton();
        this.JTPP5 = new JTextPane();
        this.JRBSiP5 = new JRadioButton();
        this.JRBNoP5 = new JRadioButton();
        this.JCHInteresSO = new JCheckBox();
        this.JTPP8 = new JTextPane();
        this.JRBSiP8 = new JRadioButton();
        this.JRBNoP8 = new JRadioButton();
        this.JBTAceptar = new JButton();
        this.JBTSalir = new JButton();
        this.JTPpyp = new JTabbedPane();
        this.JPIDatosG = new JPanel();
        this.JTPP6 = new JTextPane();
        this.JRBSiP6 = new JRadioButton();
        this.JRBNoP6 = new JRadioButton();
        this.JTPP7 = new JTextPane();
        this.JRBSiP7 = new JRadioButton();
        this.JRBNoP7 = new JRadioButton();
        this.jLabel1 = new JLabel();
        setClosable(true);
        setTitle("CIERRE DE HISTORIA CLÍNICA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifpreguntaschc");
        this.JPIPreguntas.setBorder(BorderFactory.createTitledBorder((Border) null, "PREGUNTAS DE CIERRE DE HC", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTPP2.setEditable(false);
        this.JTPP2.setBorder((Border) null);
        this.JTPP2.setFont(new Font("Arial", 1, 12));
        this.JTPP2.setForeground(Color.blue);
        this.JTPP2.setText("Se le informa al paciente el plan de manejo y compromiso en el tratamiento?");
        this.JTPP2.setOpaque(false);
        this.JTPP1.setEditable(false);
        this.JTPP1.setBorder((Border) null);
        this.JTPP1.setFont(new Font("Arial", 1, 12));
        this.JTPP1.setForeground(Color.blue);
        this.JTPP1.setText("Se le informa al paciente información basica sobre su atención?");
        this.JTPP1.setOpaque(false);
        this.JTPP3.setEditable(false);
        this.JTPP3.setBorder((Border) null);
        this.JTPP3.setFont(new Font("Arial", 1, 12));
        this.JTPP3.setForeground(Color.blue);
        this.JTPP3.setText("El paciente o familiar consideran solicitar una segunda opinión?");
        this.JTPP3.setOpaque(false);
        this.JLBSi.setFont(new Font("Arial", 1, 12));
        this.JLBSi.setForeground(Color.red);
        this.JLBSi.setHorizontalAlignment(0);
        this.JLBSi.setText("SI");
        this.JLBNo.setFont(new Font("Arial", 1, 12));
        this.JLBNo.setForeground(Color.red);
        this.JLBNo.setHorizontalAlignment(0);
        this.JLBNo.setText("NO");
        this.JBGP1.add(this.JRBSiP1);
        this.JRBSiP1.addActionListener(new ActionListener() { // from class: Historia.JIFPCierreHC.1
            public void actionPerformed(ActionEvent evt) {
                JIFPCierreHC.this.JRBSiP1ActionPerformed(evt);
            }
        });
        this.JBGP1.add(this.JRBNoP1);
        this.JRBNoP1.setSelected(true);
        this.JRBNoP1.addActionListener(new ActionListener() { // from class: Historia.JIFPCierreHC.2
            public void actionPerformed(ActionEvent evt) {
                JIFPCierreHC.this.JRBNoP1ActionPerformed(evt);
            }
        });
        this.JBGP2.add(this.JRBSiP2);
        this.JRBSiP2.addActionListener(new ActionListener() { // from class: Historia.JIFPCierreHC.3
            public void actionPerformed(ActionEvent evt) {
                JIFPCierreHC.this.JRBSiP2ActionPerformed(evt);
            }
        });
        this.JBGP2.add(this.JRBNoP2);
        this.JRBNoP2.setSelected(true);
        this.JRBNoP2.addActionListener(new ActionListener() { // from class: Historia.JIFPCierreHC.4
            public void actionPerformed(ActionEvent evt) {
                JIFPCierreHC.this.JRBNoP2ActionPerformed(evt);
            }
        });
        this.JBGP3.add(this.JRBSiP3);
        this.JRBSiP3.addActionListener(new ActionListener() { // from class: Historia.JIFPCierreHC.5
            public void actionPerformed(ActionEvent evt) {
                JIFPCierreHC.this.JRBSiP3ActionPerformed(evt);
            }
        });
        this.JBGP3.add(this.JRBNoP3);
        this.JRBNoP3.setSelected(true);
        this.JRBNoP3.addActionListener(new ActionListener() { // from class: Historia.JIFPCierreHC.6
            public void actionPerformed(ActionEvent evt) {
                JIFPCierreHC.this.JRBNoP3ActionPerformed(evt);
            }
        });
        this.JTPP4.setEditable(false);
        this.JTPP4.setBorder((Border) null);
        this.JTPP4.setFont(new Font("Arial", 1, 12));
        this.JTPP4.setForeground(Color.blue);
        this.JTPP4.setText("La atencion es producto de un evento adverso?");
        this.JTPP4.setOpaque(false);
        this.JBGP4.add(this.JRBSiP4);
        this.JRBSiP4.addActionListener(new ActionListener() { // from class: Historia.JIFPCierreHC.7
            public void actionPerformed(ActionEvent evt) {
                JIFPCierreHC.this.JRBSiP4ActionPerformed(evt);
            }
        });
        this.JBGP4.add(this.JRBNoP4);
        this.JRBNoP4.setSelected(true);
        this.JRBNoP4.addActionListener(new ActionListener() { // from class: Historia.JIFPCierreHC.8
            public void actionPerformed(ActionEvent evt) {
                JIFPCierreHC.this.JRBNoP4ActionPerformed(evt);
            }
        });
        this.JTPP5.setEditable(false);
        this.JTPP5.setBorder((Border) null);
        this.JTPP5.setFont(new Font("Arial", 1, 12));
        this.JTPP5.setForeground(Color.blue);
        this.JTPP5.setText("Esta enfermedad puede ser de origen profesional o \nproducida como condición del trabajo?");
        this.JTPP5.setOpaque(false);
        this.JBGP5.add(this.JRBSiP5);
        this.JRBSiP5.addActionListener(new ActionListener() { // from class: Historia.JIFPCierreHC.9
            public void actionPerformed(ActionEvent evt) {
                JIFPCierreHC.this.JRBSiP5ActionPerformed(evt);
            }
        });
        this.JBGP5.add(this.JRBNoP5);
        this.JRBNoP5.setSelected(true);
        this.JRBNoP5.addActionListener(new ActionListener() { // from class: Historia.JIFPCierreHC.10
            public void actionPerformed(ActionEvent evt) {
                JIFPCierreHC.this.JRBNoP5ActionPerformed(evt);
            }
        });
        this.JCHInteresSO.setFont(new Font("Arial", 1, 12));
        this.JCHInteresSO.setForeground(new Color(255, 0, 0));
        this.JCHInteresSO.setText("Es de interés para salud ocupacional?");
        this.JTPP8.setEditable(false);
        this.JTPP8.setBorder((Border) null);
        this.JTPP8.setFont(new Font("Arial", 1, 12));
        this.JTPP8.setForeground(Color.red);
        this.JTPP8.setText("El paciente es sujeto a atención especial?");
        this.JTPP8.setOpaque(false);
        this.JBGP10.add(this.JRBSiP8);
        this.JRBSiP8.addActionListener(new ActionListener() { // from class: Historia.JIFPCierreHC.11
            public void actionPerformed(ActionEvent evt) {
                JIFPCierreHC.this.JRBSiP8ActionPerformed(evt);
            }
        });
        this.JBGP10.add(this.JRBNoP8);
        this.JRBNoP8.setSelected(true);
        this.JRBNoP8.addActionListener(new ActionListener() { // from class: Historia.JIFPCierreHC.12
            public void actionPerformed(ActionEvent evt) {
                JIFPCierreHC.this.JRBNoP8ActionPerformed(evt);
            }
        });
        GroupLayout JPIPreguntasLayout = new GroupLayout(this.JPIPreguntas);
        this.JPIPreguntas.setLayout(JPIPreguntasLayout);
        JPIPreguntasLayout.setHorizontalGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPreguntasLayout.createSequentialGroup().addContainerGap().addGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIPreguntasLayout.createSequentialGroup().addComponent(this.JTPP1, -2, 402, -2).addGap(66, 66, 66).addGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPreguntasLayout.createSequentialGroup().addComponent(this.JLBSi, -2, 21, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLBNo)).addGroup(JPIPreguntasLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JRBSiP1).addGap(18, 18, 18).addComponent(this.JRBNoP1)))).addGroup(JPIPreguntasLayout.createSequentialGroup().addComponent(this.JTPP2, -2, 445, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBSiP2).addGap(18, 18, 18).addComponent(this.JRBNoP2)).addGroup(JPIPreguntasLayout.createSequentialGroup().addComponent(this.JTPP3, -2, 412, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBSiP3).addGap(18, 18, 18).addComponent(this.JRBNoP3)).addGroup(JPIPreguntasLayout.createSequentialGroup().addComponent(this.JTPP4).addGap(24, 24, 24).addComponent(this.JRBSiP4).addGap(18, 18, 18).addComponent(this.JRBNoP4)).addGroup(GroupLayout.Alignment.TRAILING, JPIPreguntasLayout.createSequentialGroup().addGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPP5, -2, 396, -2).addComponent(this.JCHInteresSO).addComponent(this.JTPP8, -2, 443, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPreguntasLayout.createSequentialGroup().addComponent(this.JRBSiP8).addGap(18, 18, 18).addComponent(this.JRBNoP8)).addGroup(JPIPreguntasLayout.createSequentialGroup().addComponent(this.JRBSiP5).addGap(18, 18, 18).addComponent(this.JRBNoP5))))).addContainerGap()));
        JPIPreguntasLayout.setVerticalGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPreguntasLayout.createSequentialGroup().addContainerGap().addGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPreguntasLayout.createSequentialGroup().addGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIPreguntasLayout.createSequentialGroup().addGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBSi).addComponent(this.JLBNo)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JRBNoP1, -1, -1, 32767).addComponent(this.JRBSiP1, GroupLayout.Alignment.TRAILING, -1, -1, 32767))).addComponent(this.JTPP1, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JRBNoP2, -1, -1, 32767).addComponent(this.JRBSiP2, GroupLayout.Alignment.TRAILING)).addComponent(this.JTPP2, -2, -1, -2)).addGap(18, 18, 18).addGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JRBNoP3, -1, -1, 32767).addComponent(this.JRBSiP3)).addComponent(this.JTPP3, -2, -1, -2)).addGap(18, 18, 18).addGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JRBNoP4, -1, -1, 32767).addComponent(this.JRBSiP4)).addComponent(this.JTPP4, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTPP5, -2, -1, -2).addGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JRBNoP5, -1, -1, 32767).addComponent(this.JRBSiP5))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, 32767).addComponent(this.JTPP8, -2, -1, -2)).addGroup(JPIPreguntasLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JRBNoP8, -1, -1, 32767).addComponent(this.JRBSiP8)))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHInteresSO).addContainerGap()));
        this.JBTAceptar.setFont(new Font("Arial", 1, 12));
        this.JBTAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAceptar.setText("Aceptar");
        this.JBTAceptar.setName("");
        this.JBTAceptar.addActionListener(new ActionListener() { // from class: Historia.JIFPCierreHC.13
            public void actionPerformed(ActionEvent evt) {
                JIFPCierreHC.this.JBTAceptarActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.setName("");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: Historia.JIFPCierreHC.14
            public void actionPerformed(ActionEvent evt) {
                JIFPCierreHC.this.JBTSalirActionPerformed(evt);
            }
        });
        this.JTPpyp.setForeground(new Color(226, 8, 9));
        this.JTPpyp.setFont(new Font("Arial", 1, 14));
        this.JTPP6.setEditable(false);
        this.JTPP6.setBorder((Border) null);
        this.JTPP6.setFont(new Font("Arial", 1, 12));
        this.JTPP6.setForeground(Color.blue);
        this.JTPP6.setText("Bajo los parámetros clínicos y/o paraclínicos, el paciente está controlado?");
        this.JTPP6.setOpaque(false);
        this.JBGP6.add(this.JRBSiP6);
        this.JRBSiP6.addActionListener(new ActionListener() { // from class: Historia.JIFPCierreHC.15
            public void actionPerformed(ActionEvent evt) {
                JIFPCierreHC.this.JRBSiP6ActionPerformed(evt);
            }
        });
        this.JBGP6.add(this.JRBNoP6);
        this.JRBNoP6.setSelected(true);
        this.JRBNoP6.addActionListener(new ActionListener() { // from class: Historia.JIFPCierreHC.16
            public void actionPerformed(ActionEvent evt) {
                JIFPCierreHC.this.JRBNoP6ActionPerformed(evt);
            }
        });
        this.JTPP7.setEditable(false);
        this.JTPP7.setBorder((Border) null);
        this.JTPP7.setFont(new Font("Arial", 1, 12));
        this.JTPP7.setForeground(Color.blue);
        this.JTPP7.setText("El paciente está adherido al tratamiento y recomendaciones?");
        this.JTPP7.setOpaque(false);
        this.JBGP7.add(this.JRBSiP7);
        this.JRBSiP7.addActionListener(new ActionListener() { // from class: Historia.JIFPCierreHC.17
            public void actionPerformed(ActionEvent evt) {
                JIFPCierreHC.this.JRBSiP7ActionPerformed(evt);
            }
        });
        this.JBGP7.add(this.JRBNoP7);
        this.JRBNoP7.setSelected(true);
        this.JRBNoP7.addActionListener(new ActionListener() { // from class: Historia.JIFPCierreHC.18
            public void actionPerformed(ActionEvent evt) {
                JIFPCierreHC.this.JRBNoP7ActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosGLayout = new GroupLayout(this.JPIDatosG);
        this.JPIDatosG.setLayout(JPIDatosGLayout);
        JPIDatosGLayout.setHorizontalGroup(JPIDatosGLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosGLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosGLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosGLayout.createSequentialGroup().addComponent(this.JTPP7, -2, 457, -2).addGap(18, 18, 18).addComponent(this.JRBSiP7).addGap(18, 18, 18).addComponent(this.JRBNoP7)).addGroup(JPIDatosGLayout.createSequentialGroup().addComponent(this.JTPP6, -2, 457, -2).addGap(18, 18, 18).addComponent(this.JRBSiP6).addGap(18, 18, 18).addComponent(this.JRBNoP6))).addContainerGap(20, 32767)));
        JPIDatosGLayout.setVerticalGroup(JPIDatosGLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosGLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosGLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosGLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JRBNoP6, -1, -1, 32767).addComponent(this.JRBSiP6, GroupLayout.Alignment.TRAILING)).addComponent(this.JTPP6, -2, -1, -2)).addGap(18, 18, 18).addGroup(JPIDatosGLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosGLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JRBNoP7, -1, -1, 32767).addComponent(this.JRBSiP7, GroupLayout.Alignment.TRAILING)).addComponent(this.JTPP7, -2, -1, -2)).addContainerGap(30, 32767)));
        this.JTPpyp.addTab("PROGRAMA DE PYP Y EPOC", this.JPIDatosG);
        this.jLabel1.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setForeground(new Color(0, 103, 0));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("DILIGENCIAR SOLO PARA:");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIPreguntas, -2, -1, -2).addComponent(this.jLabel1, -2, 570, -2)).addGap(0, 5, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JBTAceptar, -2, 264, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTSalir, -2, 272, -2)).addComponent(this.JTPpyp, -2, -1, -2)))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIPreguntas, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPpyp, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTAceptar, -2, 47, -2).addComponent(this.JBTSalir, -2, 46, -2)).addContainerGap(27, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiP1ActionPerformed(ActionEvent evt) {
        this.xp1 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoP1ActionPerformed(ActionEvent evt) {
        this.xp1 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiP2ActionPerformed(ActionEvent evt) {
        this.xp2 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoP2ActionPerformed(ActionEvent evt) {
        this.xp2 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiP3ActionPerformed(ActionEvent evt) {
        this.xp3 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoP3ActionPerformed(ActionEvent evt) {
        this.xp3 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAceptarActionPerformed(ActionEvent evt) {
        try {
            this.xjpconclusion.mAlmacenarBD(this.xp1, this.xp2, this.xp3, this.xp4, this.xp5, this.xp6, this.xp7, this.xp10);
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.xclase.mEnviarCorreoporPerimetroAbd();
                mEnviarHCSaludOcupacional();
            }
            dispose();
            this.xclase.xjifhistoriaclinica.setSelected(true);
        } catch (PropertyVetoException e) {
            Logger.getLogger(JIFPCierreHC.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiP4ActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de enviar el correo?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                this.xp4 = 1;
                String xsql = "SELECT  Ip4 FROM baseserver.h_atencion WHERE (Id ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                ResultSet rs = this.xconsultasbd.traerRs(xsql);
                if (rs.next() && rs.getInt(1) == 0) {
                    String sql = "update baseserver.h_atencion set Ip4=1 where Id ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
                    this.xconsultasbd.ejecutarSQL(sql);
                    this.xconsultasbd.cerrarConexionBd();
                    if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                        String xfrom = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
                        String mensaje = "La atención N° " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + " del paciente: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + "\nFue producto de un posible EVENTO ADVERSO y amerita aplicar el procedimiento de análisis contemplado en el Programa de Seguridad Clínica para el paciente.\n\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.informacionGeneralPrincipalDTO.getNombreEspecialidad();
                        Email em = new Email();
                        em.Send(xfrom, mensaje, "eventos@fundacionpanzenu.org.co", "EVENTO ADVERSO");
                    }
                }
                rs.close();
                this.xconsultasbd.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFPCierreHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoP4ActionPerformed(ActionEvent evt) {
        this.xp4 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiP5ActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getEsFpz().intValue() == 0 && Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de enviar el correo?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    this.xp5 = 1;
                    String xsql = "SELECT  Ip4 FROM h_atencion WHERE (Id ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                    ResultSet rs = this.xconsultasbd.traerRs(xsql);
                    if (rs.next() && rs.getInt(1) == 0) {
                        String sql = "update h_atencion set Ip4=1 where Id ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
                        this.xconsultasbd.ejecutarSQL(sql);
                        this.xconsultasbd.cerrarConexionBd();
                        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                            String xfrom = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
                            String mensaje = "La atención N° " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + " del paciente: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + "\nEste caso amerita evaluación y análisis, ante posible enfermedad profesional.\n\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.informacionGeneralPrincipalDTO.getNombreEspecialidad();
                            Email em = new Email();
                            em.Send(xfrom, mensaje, "enfprofesional@fundacionpanzenu.org.co", "CASO PARA EVALUACIÓN");
                        }
                    }
                    rs.close();
                    this.xconsultasbd.cerrarConexionBd();
                } catch (SQLException ex) {
                    Logger.getLogger(JIFPCierreHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoP5ActionPerformed(ActionEvent evt) {
        this.xp5 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiP6ActionPerformed(ActionEvent evt) {
        this.xp6 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoP6ActionPerformed(ActionEvent evt) {
        this.xp6 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiP7ActionPerformed(ActionEvent evt) {
        this.xp7 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoP7ActionPerformed(ActionEvent evt) {
        this.xp7 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiP8ActionPerformed(ActionEvent evt) {
        this.xp10 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoP8ActionPerformed(ActionEvent evt) {
        this.xp10 = 0;
    }

    private void mEnviarHCSaludOcupacional() {
        try {
            if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                Metodos xmt = new Metodos();
                String[][] mparametros = new String[4][2];
                mparametros[0][0] = "idatencion1";
                mparametros[0][1] = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
                mparametros[1][0] = "idpaciente1";
                mparametros[1][1] = String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
                mparametros[2][0] = "SUBREPORT_DIR";
                mparametros[2][1] = xmt.getSO() + xmt.getBarra() + "Reportes" + xmt.getBarra();
                mparametros[3][0] = "SUBREPORTFIRMA_DIR";
                mparametros[3][1] = xmt.getSO() + xmt.getBarra() + "Firmas" + xmt.getBarra();
                xmt.CrearPDF(xmt.getRutaRep() + "H_HistoriaClinica", mparametros, xmt.getRutaRep() + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
                Email xenviar = new Email();
                String remite = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
                if (clasesHistoriaCE.informacionAgendaMedicaDTO.getEsSaludOcupacional().intValue() == 1 && clasesHistoriaCE.informacionAgendaMedicaDTO.getIdParentesco().intValue() == 1 && clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoEmpresa().intValue() == 1) {
                    List<String> correoE = new ArrayList<>();
                    correoE.add("socmsa@fundacionpanzenu.org.co");
                    xenviar.enviarAdjunto(correoE, "Se ha realizado la atención médica del señor: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + ", con N° HC : " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + ".\nEsta atención realizada por la fundación Panzenú, es de interés para el sistema de vigilancia epidemiológico de salud ocupacional, se anexa archivo con la atención respectiva.\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.informacionGeneralPrincipalDTO.getNombreEspecialidad(), remite, "CONTRAREFERENCIA", xmt.getRutaRep() + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + ".pdf", xmt.getRutaRep() + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + ".pdf");
                }
                if (this.JCHInteresSO.isSelected()) {
                    List<String> correoE2 = new ArrayList<>();
                    correoE2.add("socmsa@fundacionpanzenu.org.co");
                    xenviar.enviarAdjunto(correoE2, "Se ha realizado la atención médica del señor: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + ", con N° HC : " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + ".\nEsta atención realizada por la fundación Panzenú, es de interés para el sistema de vigilancia epidemiológico de salud ocupacional, se anexa archivo con la atención respectiva.\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.informacionGeneralPrincipalDTO.getNombreEspecialidad(), remite, "CASO DE INTERÉS PARA SALUD OCUPACIONAL", xmt.getRutaRep() + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + ".pdf", xmt.getRutaRep() + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + ".pdf");
                }
                String sql = "SELECT r_patologiasreporte.Id_Programa FROM r_patologiasreporte INNER JOIN g_tipoentidad  ON (r_patologiasreporte.Id_TipoEntidadR = g_tipoentidad.Id)  WHERE (r_patologiasreporte.Id_Patologia ='" + this.xclase.xjifhistoriaclinica.xjifconclusion.JTFCDxP.getText() + "' AND g_tipoentidad.Es_institucion =1 AND g_tipoentidad.Id=5 AND r_patologiasreporte.Estado=1) ";
                ResultSet rs1 = this.xconsultasbd.traerRs(sql);
                if (rs1.next()) {
                    String xsql = "SELECT g_usuario_fpz.Id_Parentesco, g_usuario_fpz.Id_Empresa, g_usuario.Id_persona FROM g_usuario_fpz INNER JOIN g_usuario  ON (g_usuario_fpz.Id_Persona = g_usuario.Id_persona)  WHERE (g_usuario_fpz.Id_Parentesco =1 AND g_usuario_fpz.Id_Empresa =1 AND g_usuario.Id_persona ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') ";
                    ConsultasMySQL xct = new ConsultasMySQL();
                    ResultSet xrs = xct.traerRs(xsql);
                    if (xrs.next()) {
                        xmt.CrearPDF(xmt.getRutaRep() + "H_HistoriaClinica", mparametros, xmt.getRutaRep() + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
                        List<String> correoE3 = new ArrayList<>();
                        correoE3.add("socmsa@fundacionpanzenu.org.co");
                        xenviar.enviarAdjunto(correoE3, "Se ha realizado la atención médica del señor: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + ", con N° HC : " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + ".\nEsta atención realizada por la fundación Panzenú, es de interés para el sistema de vigilancia epidemiológico de salud ocupacional, se anexa archivo con la atención respectiva.\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.informacionGeneralPrincipalDTO.getNombreEspecialidad(), remite, "CASO DE INTERÉS PARA SALUD OCUPACIONAL", xmt.getRutaRep() + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + ".pdf", xmt.getRutaRep() + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + ".pdf");
                    }
                    xrs.close();
                    xct.cerrarConexionBd();
                }
                rs1.close();
                this.xconsultasbd.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFPCierreHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
