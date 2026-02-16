package Historia.aiepi;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/aiepi/JPAiepi04.class */
public class JPAiepi04 extends JPanel {
    private DefaultTableModel xmodeloDx;
    private Object[] xdatos;
    private int x;
    private JCheckBox JCH1;
    private JCheckBox JCH10;
    private JCheckBox JCH11;
    private JCheckBox JCH12;
    private JCheckBox JCH13;
    private JCheckBox JCH14;
    private JCheckBox JCH15;
    private JCheckBox JCH16;
    private JCheckBox JCH17;
    private JCheckBox JCH2;
    private JCheckBox JCH3;
    private JCheckBox JCH4;
    private JCheckBox JCH5;
    private JCheckBox JCH6;
    private JCheckBox JCH7;
    private JCheckBox JCH8;
    private JCheckBox JCH9;
    private JPanel JPGeneral;
    private ButtonGroup JRBGP0;
    private ButtonGroup JRBGP2;
    private ButtonGroup JRBGP3;
    private ButtonGroup JRBGP4;
    private ButtonGroup JRBGP5;
    private ButtonGroup JRBGP6;
    private ButtonGroup JRBGP7;
    private ButtonGroup JRBGPiel;
    private ButtonGroup JRBGRSocial;
    private JRadioButton JRBInadecuada;
    private JRadioButton JRBMoteada;
    private JRadioButton JRBNO;
    private JRadioButton JRBNOP2;
    private JRadioButton JRBNOP3;
    private JRadioButton JRBNOP4;
    private JRadioButton JRBNOP5;
    private JRadioButton JRBNOP6;
    private JRadioButton JRBNOP7;
    private JRadioButton JRBNormal;
    private JRadioButton JRBPalida;
    private JRadioButton JRBSAzul;
    private JRadioButton JRBSCenicienta;
    private JRadioButton JRBSI;
    private JRadioButton JRBSIP2;
    private JRadioButton JRBSIP3;
    private JRadioButton JRBSIP4;
    private JRadioButton JRBSIP5;
    private JRadioButton JRBSIP6;
    private JRadioButton JRBSIP7;
    private JRadioButton JRBSRespuesta;
    private JScrollPane JSPDiagnosticos;
    private JTextArea JTAObservacion;
    private JTable JTDx;
    private JTextField JTFDias;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String xP0 = "NO";
    private String xP2 = "NO";
    private String xP3 = "NO";
    private String xP4 = "NO";
    private String xP5 = "NO";
    private String xP6 = "";
    private String xP7 = "NO";
    private String xP8 = "";
    private String xP9 = "";
    private String xP10 = "";
    public Vector xSeleccion = new Vector();

    public JPAiepi04(int x) {
        this.x = x;
        initComponents();
        mBuscarTablaDx(x);
        mIniciaComponentes();
    }

    private void mBuscarTablaDx(int x) {
        String sql = "SELECT  `Id`, `Nbre`  FROM `p_aiepi_dx` WHERE IdPregunta=('" + x + "') order by Id ASC";
        mCreaModelodx();
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloDx.addRow(this.xdatos);
                    this.xmodeloDx.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloDx.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloDx.setValueAt(false, n, 2);
                    n++;
                }
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAiepi01.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModelodx() {
        this.xmodeloDx = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Aplica?"}) { // from class: Historia.aiepi.JPAiepi04.1
            Class[] types = {Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDx.setModel(this.xmodeloDx);
        this.JTDx.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDx.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDx.getColumnModel().getColumn(2).setPreferredWidth(30);
    }

    /* JADX WARN: Type inference failed for: r3v189, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JRBGP0 = new ButtonGroup();
        this.JRBGP2 = new ButtonGroup();
        this.JRBGP3 = new ButtonGroup();
        this.JRBGP4 = new ButtonGroup();
        this.JRBGP5 = new ButtonGroup();
        this.JRBGP6 = new ButtonGroup();
        this.JRBGP7 = new ButtonGroup();
        this.JRBGRSocial = new ButtonGroup();
        this.JRBGPiel = new ButtonGroup();
        this.jScrollPane1 = new JScrollPane();
        this.JPGeneral = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.JRBSI = new JRadioButton();
        this.JRBNO = new JRadioButton();
        this.jPanel1 = new JPanel();
        this.jLabel3 = new JLabel();
        this.JTFDias = new JTextField();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.JRBSIP2 = new JRadioButton();
        this.JRBNOP2 = new JRadioButton();
        this.jLabel6 = new JLabel();
        this.JRBSIP3 = new JRadioButton();
        this.JRBNOP3 = new JRadioButton();
        this.jLabel7 = new JLabel();
        this.JRBSIP4 = new JRadioButton();
        this.JRBNOP4 = new JRadioButton();
        this.jLabel8 = new JLabel();
        this.JRBSIP5 = new JRadioButton();
        this.JRBNOP5 = new JRadioButton();
        this.jLabel9 = new JLabel();
        this.JRBSIP6 = new JRadioButton();
        this.JRBNOP6 = new JRadioButton();
        this.jLabel10 = new JLabel();
        this.JRBSIP7 = new JRadioButton();
        this.JRBNOP7 = new JRadioButton();
        this.jPanel2 = new JPanel();
        this.JCH1 = new JCheckBox();
        this.JCH2 = new JCheckBox();
        this.JCH3 = new JCheckBox();
        this.JCH4 = new JCheckBox();
        this.jLabel11 = new JLabel();
        this.JRBNormal = new JRadioButton();
        this.JRBInadecuada = new JRadioButton();
        this.JRBSRespuesta = new JRadioButton();
        this.jLabel12 = new JLabel();
        this.JCH5 = new JCheckBox();
        this.JCH6 = new JCheckBox();
        this.JCH7 = new JCheckBox();
        this.JCH8 = new JCheckBox();
        this.JCH9 = new JCheckBox();
        this.JCH10 = new JCheckBox();
        this.JCH11 = new JCheckBox();
        this.JCH12 = new JCheckBox();
        this.JCH13 = new JCheckBox();
        this.JCH14 = new JCheckBox();
        this.JCH15 = new JCheckBox();
        this.JCH16 = new JCheckBox();
        this.JCH17 = new JCheckBox();
        this.JRBPalida = new JRadioButton();
        this.JRBMoteada = new JRadioButton();
        this.JRBSCenicienta = new JRadioButton();
        this.JRBSAzul = new JRadioButton();
        this.JSPDiagnosticos = new JScrollPane();
        this.JTDx = new JTable();
        this.jScrollPane2 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("¿TIENE FIEBRE?");
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText(" SI       NO");
        this.JRBGP0.add(this.JRBSI);
        this.JRBSI.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.2
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JRBSIActionPerformed(evt);
            }
        });
        this.JRBGP0.add(this.JRBNO);
        this.JRBNO.setSelected(true);
        this.JRBNO.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.3
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JRBNOActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setText("Hace cuanto tiempo?");
        this.JTFDias.setToolTipText("En número");
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setText("días");
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setText("Si fiebre > 5 días: Ha tenido Fiebre todos los días?");
        this.JRBGP2.add(this.JRBSIP2);
        this.JRBSIP2.setFont(new Font("Arial", 1, 12));
        this.JRBSIP2.setForeground(Color.red);
        this.JRBSIP2.setText("SI");
        this.JRBSIP2.setHorizontalTextPosition(2);
        this.JRBSIP2.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.4
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JRBSIP2ActionPerformed(evt);
            }
        });
        this.JRBGP2.add(this.JRBNOP2);
        this.JRBNOP2.setFont(new Font("Arial", 1, 12));
        this.JRBNOP2.setForeground(Color.red);
        this.JRBNOP2.setSelected(true);
        this.JRBNOP2.setText("NO");
        this.JRBNOP2.setHorizontalTextPosition(2);
        this.JRBNOP2.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.5
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JRBNOP2ActionPerformed(evt);
            }
        });
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setText("Fiebre > 38°C");
        this.JRBGP3.add(this.JRBSIP3);
        this.JRBSIP3.setFont(new Font("Arial", 1, 12));
        this.JRBSIP3.setForeground(Color.red);
        this.JRBSIP3.setText("SI");
        this.JRBSIP3.setHorizontalTextPosition(2);
        this.JRBSIP3.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.6
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JRBSIP3ActionPerformed(evt);
            }
        });
        this.JRBGP3.add(this.JRBNOP3);
        this.JRBNOP3.setFont(new Font("Arial", 1, 12));
        this.JRBNOP3.setForeground(Color.red);
        this.JRBNOP3.setSelected(true);
        this.JRBNOP3.setText("NO");
        this.JRBNOP3.setHorizontalTextPosition(2);
        this.JRBNOP3.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.7
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JRBNOP3ActionPerformed(evt);
            }
        });
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setText("Fiebre > 39°C");
        this.JRBGP4.add(this.JRBSIP4);
        this.JRBSIP4.setFont(new Font("Arial", 1, 12));
        this.JRBSIP4.setForeground(Color.red);
        this.JRBSIP4.setText("SI");
        this.JRBSIP4.setHorizontalTextPosition(2);
        this.JRBSIP4.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.8
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JRBSIP4ActionPerformed(evt);
            }
        });
        this.JRBGP4.add(this.JRBNOP4);
        this.JRBNOP4.setFont(new Font("Arial", 1, 12));
        this.JRBNOP4.setForeground(Color.red);
        this.JRBNOP4.setSelected(true);
        this.JRBNOP4.setText("NO");
        this.JRBNOP4.setHorizontalTextPosition(2);
        this.JRBNOP4.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.9
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JRBNOP4ActionPerformed(evt);
            }
        });
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setText("Vive o visitó zona de Dengue (últimos 15 días)");
        this.JRBGP5.add(this.JRBSIP5);
        this.JRBSIP5.setFont(new Font("Arial", 1, 12));
        this.JRBSIP5.setForeground(Color.red);
        this.JRBSIP5.setText("SI");
        this.JRBSIP5.setHorizontalTextPosition(2);
        this.JRBSIP5.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.10
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JRBSIP5ActionPerformed(evt);
            }
        });
        this.JRBGP5.add(this.JRBNOP5);
        this.JRBNOP5.setFont(new Font("Arial", 1, 12));
        this.JRBNOP5.setForeground(Color.red);
        this.JRBNOP5.setSelected(true);
        this.JRBNOP5.setText("NO");
        this.JRBNOP5.setHorizontalTextPosition(2);
        this.JRBNOP5.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.11
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JRBNOP5ActionPerformed(evt);
            }
        });
        this.jLabel9.setFont(new Font("Arial", 1, 12));
        this.jLabel9.setText("Zona Malaria:");
        this.JRBGP6.add(this.JRBSIP6);
        this.JRBSIP6.setFont(new Font("Arial", 1, 12));
        this.JRBSIP6.setForeground(Color.red);
        this.JRBSIP6.setText("Urbana");
        this.JRBSIP6.setHorizontalTextPosition(2);
        this.JRBSIP6.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.12
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JRBSIP6ActionPerformed(evt);
            }
        });
        this.JRBGP6.add(this.JRBNOP6);
        this.JRBNOP6.setFont(new Font("Arial", 1, 12));
        this.JRBNOP6.setForeground(Color.red);
        this.JRBNOP6.setSelected(true);
        this.JRBNOP6.setText("Rural");
        this.JRBNOP6.setHorizontalTextPosition(2);
        this.JRBNOP6.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.13
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JRBNOP6ActionPerformed(evt);
            }
        });
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setText("Disminución Diuresis:");
        this.JRBGP7.add(this.JRBSIP7);
        this.JRBSIP7.setFont(new Font("Arial", 1, 12));
        this.JRBSIP7.setForeground(Color.red);
        this.JRBSIP7.setText("SI");
        this.JRBSIP7.setHorizontalTextPosition(2);
        this.JRBSIP7.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.14
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JRBSIP7ActionPerformed(evt);
            }
        });
        this.JRBGP7.add(this.JRBNOP7);
        this.JRBNOP7.setFont(new Font("Arial", 1, 12));
        this.JRBNOP7.setForeground(Color.red);
        this.JRBNOP7.setSelected(true);
        this.JRBNOP7.setText("NO");
        this.JRBNOP7.setHorizontalTextPosition(2);
        this.JRBNOP7.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.15
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JRBNOP7ActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel3, -2, 145, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDias, -2, 47, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel4, -2, 145, -2).addGap(0, 0, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel5, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JRBSIP2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel6, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JRBSIP3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP3)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel7, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JRBSIP4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP4)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel8, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JRBSIP5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP5)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel9, -2, 175, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBSIP6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP6)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel10, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JRBSIP7).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP7))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.JTFDias, -2, -1, -2).addComponent(this.jLabel4)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP2, -2, 13, -2).addComponent(this.JRBNOP2, GroupLayout.Alignment.LEADING, -2, 13, -2))).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jLabel5, -2, 15, -2))).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP3, -2, 13, -2).addComponent(this.JRBNOP3, GroupLayout.Alignment.LEADING, -2, 13, -2)).addComponent(this.jLabel6, -2, 15, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP4, -2, 13, -2).addComponent(this.JRBNOP4, GroupLayout.Alignment.LEADING, -2, 13, -2)).addComponent(this.jLabel7)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP5, -2, 13, -2).addComponent(this.JRBNOP5, GroupLayout.Alignment.LEADING, -2, 13, -2)).addComponent(this.jLabel8)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP6, -2, 13, -2).addComponent(this.JRBNOP6, GroupLayout.Alignment.LEADING, -2, 13, -2)).addComponent(this.jLabel9)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP7, -2, 13, -2).addComponent(this.JRBNOP7, GroupLayout.Alignment.LEADING, -2, 13, -2)).addComponent(this.jLabel10))));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder(""));
        this.JCH1.setFont(new Font("Arial", 1, 11));
        this.JCH1.setText("Rigidez de nuca");
        this.JCH1.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.16
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JCH1ActionPerformed(evt);
            }
        });
        this.JCH2.setFont(new Font("Arial", 1, 11));
        this.JCH2.setText("Apariencia de enfermo grave");
        this.JCH2.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.17
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JCH2ActionPerformed(evt);
            }
        });
        this.JCH3.setFont(new Font("Arial", 1, 11));
        this.JCH3.setText("Manifestaciones de sangrado");
        this.JCH3.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.18
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JCH3ActionPerformed(evt);
            }
        });
        this.JCH4.setFont(new Font("Arial", 1, 11));
        this.JCH4.setText("Aspecto tóxico");
        this.JCH4.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.19
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JCH4ActionPerformed(evt);
            }
        });
        this.jLabel11.setFont(new Font("Arial", 1, 11));
        this.jLabel11.setText("Respuesta social:");
        this.JRBGRSocial.add(this.JRBNormal);
        this.JRBNormal.setFont(new Font("Arial", 1, 11));
        this.JRBNormal.setText("Normal");
        this.JRBNormal.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.20
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JRBNormalActionPerformed(evt);
            }
        });
        this.JRBGRSocial.add(this.JRBInadecuada);
        this.JRBInadecuada.setFont(new Font("Arial", 1, 11));
        this.JRBInadecuada.setText("Inadecuada");
        this.JRBInadecuada.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.21
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JRBInadecuadaActionPerformed(evt);
            }
        });
        this.JRBGRSocial.add(this.JRBSRespuesta);
        this.JRBSRespuesta.setFont(new Font("Arial", 1, 11));
        this.JRBSRespuesta.setText("Sin respuesta");
        this.JRBSRespuesta.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.22
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JRBSRespuestaActionPerformed(evt);
            }
        });
        this.jLabel12.setFont(new Font("Arial", 1, 11));
        this.jLabel12.setText("Piel:");
        this.JCH5.setFont(new Font("Arial", 1, 11));
        this.JCH5.setText("Erupción cutanea generalizada");
        this.JCH5.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.23
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JCH5ActionPerformed(evt);
            }
        });
        this.JCH6.setFont(new Font("Arial", 1, 11));
        this.JCH6.setText("Dolor abdominal");
        this.JCH6.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.24
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JCH6ActionPerformed(evt);
            }
        });
        this.JCH7.setFont(new Font("Arial", 1, 11));
        this.JCH7.setText("Cefalea");
        this.JCH7.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.25
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JCH7ActionPerformed(evt);
            }
        });
        this.JCH8.setFont(new Font("Arial", 1, 11));
        this.JCH8.setText("Mialgias");
        this.JCH8.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.26
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JCH8ActionPerformed(evt);
            }
        });
        this.JCH9.setFont(new Font("Arial", 1, 11));
        this.JCH9.setText("Artralgias");
        this.JCH9.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.27
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JCH9ActionPerformed(evt);
            }
        });
        this.JCH10.setFont(new Font("Arial", 1, 11));
        this.JCH10.setText("Dolor retroocular");
        this.JCH10.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.28
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JCH10ActionPerformed(evt);
            }
        });
        this.JCH11.setFont(new Font("Arial", 1, 11));
        this.JCH11.setText("Postración");
        this.JCH11.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.29
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JCH11ActionPerformed(evt);
            }
        });
        this.JCH12.setFont(new Font("Arial", 1, 11));
        this.JCH12.setText("P. torniquete (+)");
        this.JCH12.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.30
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JCH12ActionPerformed(evt);
            }
        });
        this.JCH13.setFont(new Font("Arial", 1, 11));
        this.JCH13.setText("Lipotimia");
        this.JCH13.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.31
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JCH13ActionPerformed(evt);
            }
        });
        this.JCH14.setFont(new Font("Arial", 1, 11));
        this.JCH14.setText("hepatomegalia");
        this.JCH14.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.32
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JCH14ActionPerformed(evt);
            }
        });
        this.JCH15.setFont(new Font("Arial", 1, 11));
        this.JCH15.setText("Pulso rápido y fino");
        this.JCH15.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.33
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JCH15ActionPerformed(evt);
            }
        });
        this.JCH16.setFont(new Font("Arial", 1, 11));
        this.JCH16.setText("Llenado capilar>2 seg.");
        this.JCH16.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.34
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JCH16ActionPerformed(evt);
            }
        });
        this.JCH17.setFont(new Font("Arial", 1, 11));
        this.JCH17.setText("Ascitis");
        this.JCH17.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.35
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JCH17ActionPerformed(evt);
            }
        });
        this.JRBGPiel.add(this.JRBPalida);
        this.JRBPalida.setFont(new Font("Arial", 1, 11));
        this.JRBPalida.setText("Pálida");
        this.JRBPalida.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.36
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JRBPalidaActionPerformed(evt);
            }
        });
        this.JRBGPiel.add(this.JRBMoteada);
        this.JRBMoteada.setFont(new Font("Arial", 1, 11));
        this.JRBMoteada.setText("Moteada");
        this.JRBMoteada.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.37
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JRBMoteadaActionPerformed(evt);
            }
        });
        this.JRBGPiel.add(this.JRBSCenicienta);
        this.JRBSCenicienta.setFont(new Font("Arial", 1, 11));
        this.JRBSCenicienta.setText("Cenicienta");
        this.JRBSCenicienta.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.38
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JRBSCenicientaActionPerformed(evt);
            }
        });
        this.JRBGPiel.add(this.JRBSAzul);
        this.JRBSAzul.setFont(new Font("Arial", 1, 11));
        this.JRBSAzul.setText("Azul");
        this.JRBSAzul.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi04.39
            public void actionPerformed(ActionEvent evt) {
                JPAiepi04.this.JRBSAzulActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCH7).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH8).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH10)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCH5).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH6)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCH1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH2)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCH3).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH4)).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCH11).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH12).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH13)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCH15).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH16))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH17).addComponent(this.JCH14))).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel11).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNormal).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBInadecuada)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel12).addGap(13, 13, 13).addComponent(this.JRBPalida).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBMoteada).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSCenicienta))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBSAzul).addComponent(this.JRBSRespuesta)))).addContainerGap(17, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH1).addComponent(this.JCH2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3).addComponent(this.JCH4)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH5).addComponent(this.JCH6)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH7).addComponent(this.JCH8).addComponent(this.JCH9).addComponent(this.JCH10)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH11).addComponent(this.JCH12).addComponent(this.JCH13).addComponent(this.JCH14)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH15).addComponent(this.JCH16).addComponent(this.JCH17)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel11).addComponent(this.JRBNormal).addComponent(this.JRBInadecuada).addComponent(this.JRBSRespuesta)).addGap(2, 2, 2).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBPalida).addComponent(this.JRBMoteada).addComponent(this.JRBSCenicienta).addComponent(this.JRBSAzul)).addComponent(this.jLabel12)).addContainerGap()));
        this.JSPDiagnosticos.setBorder(BorderFactory.createTitledBorder((Border) null, "Diagnósticos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTDx.setFont(new Font("Arial", 1, 12));
        this.JTDx.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDx.setSelectionBackground(new Color(255, 255, 255));
        this.JTDx.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDiagnosticos.setViewportView(this.JTDx);
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 0, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane2.setViewportView(this.JTAObservacion);
        GroupLayout JPGeneralLayout = new GroupLayout(this.JPGeneral);
        this.JPGeneral.setLayout(JPGeneralLayout);
        JPGeneralLayout.setHorizontalGroup(JPGeneralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPGeneralLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPGeneralLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel2, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPGeneralLayout.createSequentialGroup().addComponent(this.jLabel1, -2, 316, -2).addGap(8, 8, 8).addGroup(JPGeneralLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPGeneralLayout.createSequentialGroup().addComponent(this.JRBSI).addGap(10, 10, 10).addComponent(this.JRBNO)).addComponent(this.jLabel2)).addGap(0, 0, 32767)).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPGeneralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDiagnosticos, -2, 312, -2).addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING, -1, 318, 32767)).addContainerGap()));
        JPGeneralLayout.setVerticalGroup(JPGeneralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPGeneralLayout.createSequentialGroup().addGroup(JPGeneralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPGeneralLayout.createSequentialGroup().addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPGeneralLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel1).addGroup(JPGeneralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBSI).addComponent(this.JRBNO))).addGap(3, 3, 3).addComponent(this.jPanel1, -2, -1, -2)).addGroup(JPGeneralLayout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JSPDiagnosticos, -2, 176, -2))).addGap(3, 3, 3).addGroup(JPGeneralLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jScrollPane2)).addGap(24, 24, 24)));
        this.jScrollPane1.setViewportView(this.JPGeneral);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jScrollPane1, -1, 771, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jScrollPane1, -1, 348, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIActionPerformed(ActionEvent evt) {
        this.xP0 = "SI";
        mIniciaComponentes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOActionPerformed(ActionEvent evt) {
        this.xP0 = "NO";
        mIniciaComponentes();
        mBuscarTablaDx(this.x);
    }

    private void mIniciaComponentes() {
        if (this.JRBSI.isSelected()) {
            this.xmt.mEnableComponetes(this.jPanel1, true);
            this.xmt.mEnableComponetes(this.jPanel2, true);
            return;
        }
        this.xmt.mEnableComponetes(this.jPanel1, false);
        this.xmt.mEnableComponetes(this.jPanel2, false);
        this.xmt.clearPanel(this.jPanel1);
        this.xmt.clearPanel(this.jPanel2);
        this.xP2 = "NO";
        this.xP3 = "NO";
        this.xP4 = "NO";
        this.xP5 = "NO";
        this.xP6 = "";
        this.xP7 = "NO";
        this.xP8 = "";
        this.xP9 = "";
        this.xP10 = "";
        this.JRBGP2.clearSelection();
        this.JRBGP3.clearSelection();
        this.JRBGP4.clearSelection();
        this.JRBGP5.clearSelection();
        this.JRBGP6.clearSelection();
        this.JRBGP7.clearSelection();
        this.JRBGRSocial.clearSelection();
        this.JRBGPiel.clearSelection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIP2ActionPerformed(ActionEvent evt) {
        this.xP2 = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP2ActionPerformed(ActionEvent evt) {
        this.xP2 = "NO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIP3ActionPerformed(ActionEvent evt) {
        this.xP3 = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP3ActionPerformed(ActionEvent evt) {
        this.xP3 = "NO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIP4ActionPerformed(ActionEvent evt) {
        this.xP4 = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP4ActionPerformed(ActionEvent evt) {
        this.xP4 = "NO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIP5ActionPerformed(ActionEvent evt) {
        this.xP5 = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP5ActionPerformed(ActionEvent evt) {
        this.xP5 = "NO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIP6ActionPerformed(ActionEvent evt) {
        this.xP6 = this.JRBSIP6.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP6ActionPerformed(ActionEvent evt) {
        this.xP6 = this.JRBNOP6.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIP7ActionPerformed(ActionEvent evt) {
        this.xP7 = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP7ActionPerformed(ActionEvent evt) {
        this.xP7 = "NO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH1ActionPerformed(ActionEvent evt) {
        if (this.JCH1.isSelected()) {
            mAddElement(this.JCH1.getText());
        } else {
            mRemoveElement(this.JCH1.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2ActionPerformed(ActionEvent evt) {
        if (this.JCH2.isSelected()) {
            mAddElement(this.JCH2.getText());
        } else {
            mRemoveElement(this.JCH2.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3ActionPerformed(ActionEvent evt) {
        if (this.JCH3.isSelected()) {
            mAddElement(this.JCH3.getText());
        } else {
            mRemoveElement(this.JCH3.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH4ActionPerformed(ActionEvent evt) {
        if (this.JCH4.isSelected()) {
            mAddElement(this.JCH4.getText());
        } else {
            mRemoveElement(this.JCH4.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH5ActionPerformed(ActionEvent evt) {
        if (this.JCH5.isSelected()) {
            mAddElement(this.JCH5.getText());
        } else {
            mRemoveElement(this.JCH5.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH6ActionPerformed(ActionEvent evt) {
        if (this.JCH6.isSelected()) {
            mAddElement(this.JCH6.getText());
        } else {
            mRemoveElement(this.JCH6.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH7ActionPerformed(ActionEvent evt) {
        if (this.JCH7.isSelected()) {
            mAddElement(this.JCH7.getText());
        } else {
            mRemoveElement(this.JCH7.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH8ActionPerformed(ActionEvent evt) {
        if (this.JCH8.isSelected()) {
            mAddElement(this.JCH8.getText());
        } else {
            mRemoveElement(this.JCH8.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH9ActionPerformed(ActionEvent evt) {
        if (this.JCH9.isSelected()) {
            mAddElement(this.JCH9.getText());
        } else {
            mRemoveElement(this.JCH9.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH10ActionPerformed(ActionEvent evt) {
        if (this.JCH10.isSelected()) {
            mAddElement(this.JCH10.getText());
        } else {
            mRemoveElement(this.JCH10.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH11ActionPerformed(ActionEvent evt) {
        if (this.JCH11.isSelected()) {
            mAddElement(this.JCH11.getText());
        } else {
            mRemoveElement(this.JCH11.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH12ActionPerformed(ActionEvent evt) {
        if (this.JCH12.isSelected()) {
            mAddElement(this.JCH12.getText());
        } else {
            mRemoveElement(this.JCH12.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH13ActionPerformed(ActionEvent evt) {
        if (this.JCH13.isSelected()) {
            mAddElement(this.JCH13.getText());
        } else {
            mRemoveElement(this.JCH13.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH14ActionPerformed(ActionEvent evt) {
        if (this.JCH14.isSelected()) {
            mAddElement(this.JCH14.getText());
        } else {
            mRemoveElement(this.JCH14.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH15ActionPerformed(ActionEvent evt) {
        if (this.JCH15.isSelected()) {
            mAddElement(this.JCH15.getText());
        } else {
            mRemoveElement(this.JCH15.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH16ActionPerformed(ActionEvent evt) {
        if (this.JCH16.isSelected()) {
            mAddElement(this.JCH16.getText());
        } else {
            mRemoveElement(this.JCH16.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH17ActionPerformed(ActionEvent evt) {
        if (this.JCH17.isSelected()) {
            mAddElement(this.JCH17.getText());
        } else {
            mRemoveElement(this.JCH17.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNormalActionPerformed(ActionEvent evt) {
        this.xP9 = this.JRBNormal.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBInadecuadaActionPerformed(ActionEvent evt) {
        this.xP9 = this.JRBInadecuada.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSRespuestaActionPerformed(ActionEvent evt) {
        this.xP9 = this.JRBSRespuesta.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPalidaActionPerformed(ActionEvent evt) {
        this.xP10 = this.JRBPalida.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMoteadaActionPerformed(ActionEvent evt) {
        this.xP10 = this.JRBMoteada.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSCenicientaActionPerformed(ActionEvent evt) {
        this.xP10 = this.JRBSCenicienta.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSAzulActionPerformed(ActionEvent evt) {
        this.xP10 = this.JRBSAzul.getText();
    }

    private void mAddElement(String x) {
        this.xSeleccion.addElement(x);
        mViewElements();
    }

    private void mRemoveElement(String x) {
        int i = 0;
        while (true) {
            if (i >= this.xSeleccion.size()) {
                break;
            }
            if (!x.equals(this.xSeleccion.elementAt(i))) {
                i++;
            } else {
                this.xSeleccion.removeElementAt(i);
                break;
            }
        }
        mViewElements();
    }

    private void mViewElements() {
        String string;
        String resultado = "";
        for (int i = 0; i < this.xSeleccion.size(); i++) {
            if (resultado.equals("")) {
                string = this.xSeleccion.elementAt(i).toString();
            } else {
                string = resultado + " , " + this.xSeleccion.elementAt(i);
            }
            resultado = string;
        }
        this.xP8 = resultado;
    }

    public void mGuardar(String xidExamen) {
        String sql = "INSERT INTO `p_aiepi_pd` ( `IdEva_AIEPI`, `P0`, `P1`, `P2`, `P3`, `P4`, `P5`, `P6`, `P7`, `P8`, `P9`, `P10`, `Observaciones`, `UsuarioS`) VALUES ( '" + xidExamen + "', '" + this.xP0 + "', '" + this.JTFDias.getText() + "', '" + this.xP2 + "', '" + this.xP3 + "', '" + this.xP4 + "', '" + this.xP5 + "', '" + this.xP6 + "', '" + this.xP7 + "', '" + this.xP8 + "', '" + this.xP9 + "', '" + this.xP10 + "', '" + this.JTAObservacion.getText() + "',  '" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
        for (int y = 0; y < this.JTDx.getRowCount(); y++) {
            if (Boolean.valueOf(this.xmodeloDx.getValueAt(y, 2).toString()).booleanValue()) {
                String sql2 = "INSERT INTO  `p_aiepi_dx_resultado` (`IdDx`, `IdEvaluacion`, `UsuarioS`) VALUES ('" + this.xmodeloDx.getValueAt(y, 0).toString() + "', '" + xidExamen + "', '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                this.xct.ejecutarSQL(sql2);
                this.xct.cerrarConexionBd();
            }
        }
    }
}
