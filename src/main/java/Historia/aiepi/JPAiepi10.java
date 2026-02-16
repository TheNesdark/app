package Historia.aiepi;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
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

/* JADX INFO: loaded from: GenomaP.jar:Historia/aiepi/JPAiepi10.class */
public class JPAiepi10 extends JPanel {
    private DefaultTableModel xmodeloDx;
    private Object[] xdatos;
    private ButtonGroup JBG01;
    private ButtonGroup JBG2;
    private ButtonGroup JBG3;
    private ButtonGroup JBG4;
    private ButtonGroup JBG5;
    private ButtonGroup JBG6;
    private ButtonGroup JBG7;
    private ButtonGroup JBG8;
    private JCheckBox JCH1;
    private JCheckBox JCH10;
    private JCheckBox JCH11;
    private JCheckBox JCH12;
    private JCheckBox JCH13;
    private JCheckBox JCH14;
    private JCheckBox JCH15;
    private JCheckBox JCH16;
    private JCheckBox JCH17;
    private JCheckBox JCH18;
    private JCheckBox JCH19;
    private JCheckBox JCH2;
    private JCheckBox JCH20;
    private JCheckBox JCH21;
    private JCheckBox JCH22;
    private JCheckBox JCH23;
    private JCheckBox JCH24;
    private JCheckBox JCH25;
    private JCheckBox JCH26;
    private JCheckBox JCH27;
    private JCheckBox JCH28;
    private JCheckBox JCH29;
    private JCheckBox JCH3;
    private JCheckBox JCH4;
    private JCheckBox JCH5;
    private JCheckBox JCH6;
    private JCheckBox JCH7;
    private JCheckBox JCH8;
    private JCheckBox JCH9;
    private JRadioButton JRBNOP14;
    private JRadioButton JRBNOP18;
    private JRadioButton JRBNOP2;
    private JRadioButton JRBNOP3;
    private JRadioButton JRBNOP4;
    private JRadioButton JRBNOP5;
    private JRadioButton JRBNOP6;
    private JRadioButton JRBNOP8;
    private JRadioButton JRBSIP14;
    private JRadioButton JRBSIP18;
    private JRadioButton JRBSIP2;
    private JRadioButton JRBSIP3;
    private JRadioButton JRBSIP4;
    private JRadioButton JRBSIP5;
    private JRadioButton JRBSIP6;
    private JRadioButton JRBSIP8;
    private JScrollPane JSPDiagnosticos;
    private JTextArea JTAObservacion;
    private JTable JTDx;
    private JTextField JTFP1;
    private JTextField JTFP2;
    private JTextField JTFP3;
    private JTextField JTFP4;
    private JTextField JTFP5;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel20;
    private JLabel jLabel21;
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
    private String xP2 = "NO";
    private String xP4 = "NO";
    private String xP7 = "NO";
    private String xP8 = "NO";
    private String xP9 = "NO";
    private String xP10 = "NO";
    private String xP14 = "NO";
    private String xP18 = "NO";
    private String xP3 = "";
    private String xP5 = "";
    private String xP13 = "";
    private String xP16 = "";
    private String xP17 = "";
    private String xP19 = "";
    public Vector xSeleccion3 = new Vector();
    public Vector xSeleccion5 = new Vector();
    public Vector xSeleccion13 = new Vector();
    public Vector xSeleccion16 = new Vector();
    public Vector xSeleccion17 = new Vector();
    public Vector xSeleccion19 = new Vector();

    public JPAiepi10(int x) {
        initComponents();
        mBuscarTablaDx(x);
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
        this.xmodeloDx = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Aplica?"}) { // from class: Historia.aiepi.JPAiepi10.1
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

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG01 = new ButtonGroup();
        this.JBG2 = new ButtonGroup();
        this.JBG3 = new ButtonGroup();
        this.JBG4 = new ButtonGroup();
        this.JBG5 = new ButtonGroup();
        this.JBG6 = new ButtonGroup();
        this.JBG7 = new ButtonGroup();
        this.JBG8 = new ButtonGroup();
        this.jScrollPane1 = new JScrollPane();
        this.jPanel1 = new JPanel();
        this.jLabel4 = new JLabel();
        this.JTFP1 = new JTextField();
        this.JSPDiagnosticos = new JScrollPane();
        this.JTDx = new JTable();
        this.jLabel5 = new JLabel();
        this.JRBSIP2 = new JRadioButton();
        this.JRBNOP2 = new JRadioButton();
        this.JCH1 = new JCheckBox();
        this.jLabel6 = new JLabel();
        this.JCH2 = new JCheckBox();
        this.JCH3 = new JCheckBox();
        this.jLabel7 = new JLabel();
        this.JTFP2 = new JTextField();
        this.jLabel8 = new JLabel();
        this.JRBSIP3 = new JRadioButton();
        this.JRBNOP3 = new JRadioButton();
        this.jLabel9 = new JLabel();
        this.JRBSIP4 = new JRadioButton();
        this.JRBNOP4 = new JRadioButton();
        this.jLabel10 = new JLabel();
        this.JRBSIP5 = new JRadioButton();
        this.JRBNOP5 = new JRadioButton();
        this.jLabel11 = new JLabel();
        this.JRBSIP6 = new JRadioButton();
        this.JRBNOP6 = new JRadioButton();
        this.jLabel12 = new JLabel();
        this.JTFP3 = new JTextField();
        this.jLabel13 = new JLabel();
        this.JTFP4 = new JTextField();
        this.jLabel14 = new JLabel();
        this.JCH4 = new JCheckBox();
        this.JCH5 = new JCheckBox();
        this.JCH6 = new JCheckBox();
        this.JCH7 = new JCheckBox();
        this.jLabel15 = new JLabel();
        this.JCH8 = new JCheckBox();
        this.JCH9 = new JCheckBox();
        this.JCH10 = new JCheckBox();
        this.JCH11 = new JCheckBox();
        this.jLabel16 = new JLabel();
        this.JCH12 = new JCheckBox();
        this.JCH13 = new JCheckBox();
        this.jLabel17 = new JLabel();
        this.JRBSIP18 = new JRadioButton();
        this.JRBNOP18 = new JRadioButton();
        this.jPanel2 = new JPanel();
        this.JCH14 = new JCheckBox();
        this.JCH15 = new JCheckBox();
        this.JCH16 = new JCheckBox();
        this.JCH17 = new JCheckBox();
        this.JCH18 = new JCheckBox();
        this.JCH19 = new JCheckBox();
        this.JCH20 = new JCheckBox();
        this.JCH21 = new JCheckBox();
        this.JCH22 = new JCheckBox();
        this.JCH23 = new JCheckBox();
        this.JCH24 = new JCheckBox();
        this.JCH25 = new JCheckBox();
        this.JCH26 = new JCheckBox();
        this.jScrollPane2 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.jLabel18 = new JLabel();
        this.JRBSIP8 = new JRadioButton();
        this.JRBNOP8 = new JRadioButton();
        this.jLabel19 = new JLabel();
        this.JCH27 = new JCheckBox();
        this.JCH28 = new JCheckBox();
        this.JCH29 = new JCheckBox();
        this.jLabel20 = new JLabel();
        this.JRBSIP14 = new JRadioButton();
        this.JRBNOP14 = new JRadioButton();
        this.jLabel21 = new JLabel();
        this.JTFP5 = new JTextField();
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setText("¿Cómo se produjeron las lesiones?");
        this.JTFP1.setToolTipText("En número");
        this.JSPDiagnosticos.setBorder(BorderFactory.createTitledBorder((Border) null, "Diagnósticos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTDx.setFont(new Font("Arial", 1, 12));
        this.JTDx.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDx.setSelectionBackground(new Color(255, 255, 255));
        this.JTDx.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDiagnosticos.setViewportView(this.JTDx);
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setText("¿El niño relata maltrato?");
        this.JBG01.add(this.JRBSIP2);
        this.JRBSIP2.setFont(new Font("Arial", 1, 12));
        this.JRBSIP2.setForeground(Color.red);
        this.JRBSIP2.setText("SI");
        this.JRBSIP2.setHorizontalTextPosition(2);
        this.JRBSIP2.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.2
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JRBSIP2ActionPerformed(evt);
            }
        });
        this.JBG01.add(this.JRBNOP2);
        this.JRBNOP2.setFont(new Font("Arial", 1, 12));
        this.JRBNOP2.setForeground(Color.red);
        this.JRBNOP2.setSelected(true);
        this.JRBNOP2.setText("NO");
        this.JRBNOP2.setHorizontalTextPosition(2);
        this.JRBNOP2.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.3
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JRBNOP2ActionPerformed(evt);
            }
        });
        this.JCH1.setFont(new Font("Arial", 1, 12));
        this.JCH1.setText("Físico");
        this.JCH1.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.4
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH1ActionPerformed(evt);
            }
        });
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setText("¿Cual?");
        this.JCH2.setFont(new Font("Arial", 1, 12));
        this.JCH2.setText("Sexual");
        this.JCH2.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.5
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH2ActionPerformed(evt);
            }
        });
        this.JCH3.setFont(new Font("Arial", 1, 12));
        this.JCH3.setText("Negligencia");
        this.JCH3.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.6
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH3ActionPerformed(evt);
            }
        });
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setText("¿Quién?");
        this.JTFP2.setToolTipText("En número");
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setText("¿Hay incongruencia para explicar un Trauma significante?");
        this.JBG2.add(this.JRBSIP3);
        this.JRBSIP3.setFont(new Font("Arial", 1, 12));
        this.JRBSIP3.setForeground(Color.red);
        this.JRBSIP3.setText("SI");
        this.JRBSIP3.setHorizontalTextPosition(2);
        this.JRBSIP3.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.7
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JRBSIP3ActionPerformed(evt);
            }
        });
        this.JBG2.add(this.JRBNOP3);
        this.JRBNOP3.setFont(new Font("Arial", 1, 12));
        this.JRBNOP3.setForeground(Color.red);
        this.JRBNOP3.setSelected(true);
        this.JRBNOP3.setText("NO");
        this.JRBNOP3.setHorizontalTextPosition(2);
        this.JRBNOP3.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.8
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JRBNOP3ActionPerformed(evt);
            }
        });
        this.jLabel9.setFont(new Font("Arial", 1, 12));
        this.jLabel9.setText("¿Existe incongruencia entre lesion – edad- desarrollo del niño?");
        this.JBG3.add(this.JRBSIP4);
        this.JRBSIP4.setFont(new Font("Arial", 1, 12));
        this.JRBSIP4.setForeground(Color.red);
        this.JRBSIP4.setText("SI");
        this.JRBSIP4.setHorizontalTextPosition(2);
        this.JRBSIP4.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.9
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JRBSIP4ActionPerformed(evt);
            }
        });
        this.JBG3.add(this.JRBNOP4);
        this.JRBNOP4.setFont(new Font("Arial", 1, 12));
        this.JRBNOP4.setForeground(Color.red);
        this.JRBNOP4.setSelected(true);
        this.JRBNOP4.setText("NO");
        this.JRBNOP4.setHorizontalTextPosition(2);
        this.JRBNOP4.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.10
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JRBNOP4ActionPerformed(evt);
            }
        });
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setText("¿Hay diferentes versiones?");
        this.JBG4.add(this.JRBSIP5);
        this.JRBSIP5.setFont(new Font("Arial", 1, 12));
        this.JRBSIP5.setForeground(Color.red);
        this.JRBSIP5.setText("SI");
        this.JRBSIP5.setHorizontalTextPosition(2);
        this.JRBSIP5.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.11
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JRBSIP5ActionPerformed(evt);
            }
        });
        this.JBG4.add(this.JRBNOP5);
        this.JRBNOP5.setFont(new Font("Arial", 1, 12));
        this.JRBNOP5.setForeground(Color.red);
        this.JRBNOP5.setSelected(true);
        this.JRBNOP5.setText("NO");
        this.JRBNOP5.setHorizontalTextPosition(2);
        this.JRBNOP5.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.12
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JRBNOP5ActionPerformed(evt);
            }
        });
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setText("¿Es tardía la consulta?");
        this.JBG5.add(this.JRBSIP6);
        this.JRBSIP6.setFont(new Font("Arial", 1, 12));
        this.JRBSIP6.setForeground(Color.red);
        this.JRBSIP6.setText("SI");
        this.JRBSIP6.setHorizontalTextPosition(2);
        this.JRBSIP6.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.13
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JRBSIP6ActionPerformed(evt);
            }
        });
        this.JBG5.add(this.JRBNOP6);
        this.JRBNOP6.setFont(new Font("Arial", 1, 12));
        this.JRBNOP6.setForeground(Color.red);
        this.JRBNOP6.setSelected(true);
        this.JRBNOP6.setText("NO");
        this.JRBNOP6.setHorizontalTextPosition(2);
        this.JRBNOP6.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.14
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JRBNOP6ActionPerformed(evt);
            }
        });
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setText("<html><p align=\"justify\">¿Conqué frecuencia se ve obligado a Pegarle a su hijo?</p></html>\n");
        this.JTFP3.setToolTipText("En número");
        this.jLabel13.setFont(new Font("Arial", 1, 12));
        this.jLabel13.setText("<html><p align=\"justify\">¿Qué tan desobediente es su hijo que se ve obligado a pegarle?</p></html> ");
        this.JTFP4.setToolTipText("En número");
        this.jLabel14.setFont(new Font("Arial", 1, 12));
        this.jLabel14.setText("Comportamiento anormal de los padres:");
        this.JCH4.setFont(new Font("Arial", 1, 12));
        this.JCH4.setText("Desespero");
        this.JCH4.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.15
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH4ActionPerformed(evt);
            }
        });
        this.JCH5.setFont(new Font("Arial", 1, 12));
        this.JCH5.setText("impaciencia");
        this.JCH5.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.16
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH5ActionPerformed(evt);
            }
        });
        this.JCH6.setFont(new Font("Arial", 1, 12));
        this.JCH6.setText("intolerancia");
        this.JCH6.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.17
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH6ActionPerformed(evt);
            }
        });
        this.JCH7.setFont(new Font("Arial", 1, 12));
        this.JCH7.setText("Agresividad en la consulta");
        this.JCH7.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.18
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH7ActionPerformed(evt);
            }
        });
        this.jLabel15.setFont(new Font("Arial", 1, 12));
        this.jLabel15.setText("¿Esta el niño descuidado en:");
        this.JCH8.setFont(new Font("Arial", 1, 12));
        this.JCH8.setText("Higiene");
        this.JCH8.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.19
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH8ActionPerformed(evt);
            }
        });
        this.JCH9.setFont(new Font("Arial", 1, 12));
        this.JCH9.setText("Protección");
        this.JCH9.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.20
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH9ActionPerformed(evt);
            }
        });
        this.JCH10.setFont(new Font("Arial", 1, 12));
        this.JCH10.setText("Alimentación");
        this.JCH10.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.21
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH10ActionPerformed(evt);
            }
        });
        this.JCH11.setFont(new Font("Arial", 1, 12));
        this.JCH11.setText("Niño de calle");
        this.JCH11.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.22
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH11ActionPerformed(evt);
            }
        });
        this.jLabel16.setFont(new Font("Arial", 1, 12));
        this.jLabel16.setText("Factor de riesgo:");
        this.JCH12.setFont(new Font("Arial", 1, 12));
        this.JCH12.setText("Discapacitado");
        this.JCH12.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.23
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH12ActionPerformed(evt);
            }
        });
        this.JCH13.setFont(new Font("Arial", 1, 12));
        this.JCH13.setText("Hiperactivo");
        this.JCH13.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.24
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH13ActionPerformed(evt);
            }
        });
        this.jLabel17.setFont(new Font("Arial", 1, 12));
        this.jLabel17.setText("¿Actitud anormal del niño?");
        this.JBG6.add(this.JRBSIP18);
        this.JRBSIP18.setFont(new Font("Arial", 1, 12));
        this.JRBSIP18.setForeground(Color.red);
        this.JRBSIP18.setText("SI");
        this.JRBSIP18.setHorizontalTextPosition(2);
        this.JRBSIP18.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.25
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JRBSIP18ActionPerformed(evt);
            }
        });
        this.JBG6.add(this.JRBNOP18);
        this.JRBNOP18.setFont(new Font("Arial", 1, 12));
        this.JRBNOP18.setForeground(Color.red);
        this.JRBNOP18.setSelected(true);
        this.JRBNOP18.setText("NO");
        this.JRBNOP18.setHorizontalTextPosition(2);
        this.JRBNOP18.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.26
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JRBNOP18ActionPerformed(evt);
            }
        });
        this.jPanel2.setBorder(BorderFactory.createTitledBorder(""));
        this.JCH14.setFont(new Font("Arial", 1, 12));
        this.JCH14.setText("Temeroso");
        this.JCH14.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.27
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH14ActionPerformed(evt);
            }
        });
        this.JCH15.setFont(new Font("Arial", 1, 12));
        this.JCH15.setText("Retraido");
        this.JCH15.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.28
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH15ActionPerformed(evt);
            }
        });
        this.JCH16.setFont(new Font("Arial", 1, 12));
        this.JCH16.setText("Rechazo adulto");
        this.JCH16.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.29
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH16ActionPerformed(evt);
            }
        });
        this.JCH17.setFont(new Font("Arial", 1, 12));
        this.JCH17.setText("Evita contacto visual");
        this.JCH17.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.30
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH17ActionPerformed(evt);
            }
        });
        this.JCH18.setFont(new Font("Arial", 1, 12));
        this.JCH18.setText("Trastorno sueño");
        this.JCH18.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.31
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH18ActionPerformed(evt);
            }
        });
        this.JCH19.setFont(new Font("Arial", 1, 12));
        this.JCH19.setText("Trastorno alimentario");
        this.JCH19.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.32
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH19ActionPerformed(evt);
            }
        });
        this.JCH20.setFont(new Font("Arial", 1, 12));
        this.JCH20.setText("Problemas psicosomáticos");
        this.JCH20.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.33
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH20ActionPerformed(evt);
            }
        });
        this.JCH21.setFont(new Font("Arial", 1, 12));
        this.JCH21.setText("Conductas regresivas");
        this.JCH21.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.34
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH21ActionPerformed(evt);
            }
        });
        this.JCH22.setFont(new Font("Arial", 1, 12));
        this.JCH22.setText("Desarrollo estancado");
        this.JCH22.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.35
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH22ActionPerformed(evt);
            }
        });
        this.JCH23.setFont(new Font("Arial", 1, 12));
        this.JCH23.setText("Violencia intrafamiliar");
        this.JCH23.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.36
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH23ActionPerformed(evt);
            }
        });
        this.JCH24.setFont(new Font("Arial", 1, 12));
        this.JCH24.setText("Familia caótica");
        this.JCH24.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.37
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH24ActionPerformed(evt);
            }
        });
        this.JCH25.setFont(new Font("Arial", 1, 12));
        this.JCH25.setText("Cuidadores adictos");
        this.JCH25.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.38
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH25ActionPerformed(evt);
            }
        });
        this.JCH26.setFont(new Font("Arial", 1, 12));
        this.JCH26.setText("Deprimido");
        this.JCH26.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.39
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH26ActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCH14).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH15).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH16).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH17).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH18)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCH19).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH20).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH21).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH22)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCH23).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH24).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH25).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH26))).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH14).addComponent(this.JCH15).addComponent(this.JCH16).addComponent(this.JCH17).addComponent(this.JCH18)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH19).addComponent(this.JCH20).addComponent(this.JCH21).addComponent(this.JCH22)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH23).addComponent(this.JCH24).addComponent(this.JCH25).addComponent(this.JCH26)).addContainerGap(-1, 32767)));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 0, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane2.setViewportView(this.JTAObservacion);
        this.jLabel18.setFont(new Font("Arial", 1, 12));
        this.jLabel18.setText("¿Testigo relata maltrato?");
        this.JBG7.add(this.JRBSIP8);
        this.JRBSIP8.setFont(new Font("Arial", 1, 12));
        this.JRBSIP8.setForeground(Color.red);
        this.JRBSIP8.setText("SI");
        this.JRBSIP8.setHorizontalTextPosition(2);
        this.JRBSIP8.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.40
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JRBSIP8ActionPerformed(evt);
            }
        });
        this.JBG7.add(this.JRBNOP8);
        this.JRBNOP8.setFont(new Font("Arial", 1, 12));
        this.JRBNOP8.setForeground(Color.red);
        this.JRBNOP8.setSelected(true);
        this.JRBNOP8.setText("NO");
        this.JRBNOP8.setHorizontalTextPosition(2);
        this.JRBNOP8.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.41
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JRBNOP8ActionPerformed(evt);
            }
        });
        this.jLabel19.setFont(new Font("Arial", 1, 12));
        this.jLabel19.setText("¿Cual?");
        this.JCH27.setFont(new Font("Arial", 1, 12));
        this.JCH27.setText("Físico");
        this.JCH27.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.42
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH27ActionPerformed(evt);
            }
        });
        this.JCH28.setFont(new Font("Arial", 1, 12));
        this.JCH28.setText("Sexual");
        this.JCH28.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.43
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH28ActionPerformed(evt);
            }
        });
        this.JCH29.setFont(new Font("Arial", 1, 12));
        this.JCH29.setText("Negligencia");
        this.JCH29.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.44
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JCH29ActionPerformed(evt);
            }
        });
        this.jLabel20.setFont(new Font("Arial", 1, 12));
        this.jLabel20.setText("¿Esta el niño descuidado en su salud?");
        this.JBG8.add(this.JRBSIP14);
        this.JRBSIP14.setFont(new Font("Arial", 1, 12));
        this.JRBSIP14.setForeground(Color.red);
        this.JRBSIP14.setText("SI");
        this.JRBSIP14.setHorizontalTextPosition(2);
        this.JRBSIP14.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.45
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JRBSIP14ActionPerformed(evt);
            }
        });
        this.JBG8.add(this.JRBNOP14);
        this.JRBNOP14.setFont(new Font("Arial", 1, 12));
        this.JRBNOP14.setForeground(Color.red);
        this.JRBNOP14.setSelected(true);
        this.JRBNOP14.setText("NO");
        this.JRBNOP14.setHorizontalTextPosition(2);
        this.JRBNOP14.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi10.46
            public void actionPerformed(ActionEvent evt) {
                JPAiepi10.this.JRBNOP14ActionPerformed(evt);
            }
        });
        this.jLabel21.setFont(new Font("Arial", 1, 12));
        this.jLabel21.setText("Por:");
        this.JTFP5.setToolTipText("En número");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel10, -1, 161, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSIP5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP5).addGap(211, 211, 211)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel11, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSIP6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP6).addGap(212, 212, 212)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel9, -1, -1, 32767).addGap(0, 0, 0).addComponent(this.JRBSIP4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP4)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel12, -2, 193, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFP3)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel7, -2, 57, -2).addGroup(jPanel1Layout.createSequentialGroup().addGap(4, 4, 4).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFP1, -2, 183, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel5, -2, 183, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSIP2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel6, -2, 47, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCH1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3)).addComponent(this.JTFP2))))).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel8).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSIP3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP3)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel18, -2, 183, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSIP8).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP8)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel19, -2, 47, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH27).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH28).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH29))).addGap(0, 0, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDiagnosticos, -2, 324, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel13, -2, 193, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFP4).addGap(330, 330, 330)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2)).addComponent(this.jLabel14, -2, 236, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCH4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH5).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH6).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH7)).addComponent(this.jLabel15, -2, 236, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel16, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH12).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH13)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel17, -2, 183, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSIP18).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP18)).addComponent(this.jPanel2, -2, -1, -2).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel20, -2, 224, -2).addGap(3, 3, 3).addComponent(this.JRBSIP14).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP14).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel21, -1, -1, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCH8).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH9).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH10).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH11))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFP5, -2, 193, -2))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.JTFP1, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP2, -2, 13, -2).addComponent(this.JRBNOP2, GroupLayout.Alignment.LEADING, -2, 13, -2))).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6).addComponent(this.JCH1).addComponent(this.JCH2).addComponent(this.JCH3)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP8, -2, 13, -2).addComponent(this.JRBNOP8, GroupLayout.Alignment.LEADING, -2, 13, -2))).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel19).addComponent(this.JCH27).addComponent(this.JCH28).addComponent(this.JCH29)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.JTFP2, -2, -1, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel8).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP3, -2, 13, -2).addComponent(this.JRBNOP3, GroupLayout.Alignment.LEADING, -2, 13, -2))).addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel9).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP4, -2, 13, -2).addComponent(this.JRBNOP4, GroupLayout.Alignment.LEADING, -2, 13, -2))).addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel10).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP5, -2, 13, -2).addComponent(this.JRBNOP5, GroupLayout.Alignment.LEADING, -2, 13, -2))).addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel11).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP6, -2, 13, -2).addComponent(this.JRBNOP6, GroupLayout.Alignment.LEADING, -2, 13, -2))).addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel12, -2, -1, -2).addComponent(this.JTFP3, -2, -1, -2)).addGap(7, 7, 7).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel13, -2, -1, -2).addComponent(this.JTFP4, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel14).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH4).addComponent(this.JCH5).addComponent(this.JCH6).addComponent(this.JCH7)).addGap(1, 1, 1).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel20).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel21).addComponent(this.JTFP5, -2, -1, -2)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNOP14, -2, 13, -2).addComponent(this.JRBSIP14, -2, 13, -2))).addGap(3, 3, 3).addComponent(this.jLabel15).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH8).addComponent(this.JCH9).addComponent(this.JCH10).addComponent(this.JCH11)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel16).addComponent(this.JCH12).addComponent(this.JCH13)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel17).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP18, -2, 13, -2).addComponent(this.JRBNOP18, GroupLayout.Alignment.LEADING, -2, 13, -2)))).addComponent(this.JSPDiagnosticos, -2, 188, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jScrollPane2, -2, 81, -2).addGap(3, 3, 3)));
        this.jScrollPane1.setViewportView(this.jPanel1);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 410, 32767));
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
    public void JCH1ActionPerformed(ActionEvent evt) {
        if (this.JCH1.isSelected()) {
            mAddElement(this.JCH1.getText(), 3L);
        } else {
            mRemoveElement(this.JCH1.getText(), 3L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2ActionPerformed(ActionEvent evt) {
        if (this.JCH2.isSelected()) {
            mAddElement(this.JCH2.getText(), 3L);
        } else {
            mRemoveElement(this.JCH2.getText(), 3L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3ActionPerformed(ActionEvent evt) {
        if (this.JCH3.isSelected()) {
            mAddElement(this.JCH3.getText(), 3L);
        } else {
            mRemoveElement(this.JCH3.getText(), 3L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIP3ActionPerformed(ActionEvent evt) {
        this.xP7 = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP3ActionPerformed(ActionEvent evt) {
        this.xP7 = "NO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIP4ActionPerformed(ActionEvent evt) {
        this.xP8 = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP4ActionPerformed(ActionEvent evt) {
        this.xP8 = "NO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIP5ActionPerformed(ActionEvent evt) {
        this.xP9 = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP5ActionPerformed(ActionEvent evt) {
        this.xP9 = "NO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIP6ActionPerformed(ActionEvent evt) {
        this.xP10 = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP6ActionPerformed(ActionEvent evt) {
        this.xP10 = "NO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH4ActionPerformed(ActionEvent evt) {
        if (this.JCH4.isSelected()) {
            mAddElement(this.JCH4.getText(), 13L);
        } else {
            mRemoveElement(this.JCH4.getText(), 13L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH5ActionPerformed(ActionEvent evt) {
        if (this.JCH5.isSelected()) {
            mAddElement(this.JCH5.getText(), 13L);
        } else {
            mRemoveElement(this.JCH5.getText(), 13L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH6ActionPerformed(ActionEvent evt) {
        if (this.JCH6.isSelected()) {
            mAddElement(this.JCH6.getText(), 13L);
        } else {
            mRemoveElement(this.JCH6.getText(), 13L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH7ActionPerformed(ActionEvent evt) {
        if (this.JCH7.isSelected()) {
            mAddElement(this.JCH7.getText(), 13L);
        } else {
            mRemoveElement(this.JCH7.getText(), 13L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH8ActionPerformed(ActionEvent evt) {
        if (this.JCH8.isSelected()) {
            mAddElement(this.JCH8.getText(), 16L);
        } else {
            mRemoveElement(this.JCH8.getText(), 16L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH9ActionPerformed(ActionEvent evt) {
        if (this.JCH9.isSelected()) {
            mAddElement(this.JCH9.getText(), 16L);
        } else {
            mRemoveElement(this.JCH9.getText(), 16L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH10ActionPerformed(ActionEvent evt) {
        if (this.JCH10.isSelected()) {
            mAddElement(this.JCH10.getText(), 16L);
        } else {
            mRemoveElement(this.JCH10.getText(), 16L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH11ActionPerformed(ActionEvent evt) {
        if (this.JCH11.isSelected()) {
            mAddElement(this.JCH11.getText(), 16L);
        } else {
            mRemoveElement(this.JCH11.getText(), 16L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH12ActionPerformed(ActionEvent evt) {
        if (this.JCH12.isSelected()) {
            mAddElement(this.JCH12.getText(), 17L);
        } else {
            mRemoveElement(this.JCH12.getText(), 17L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH13ActionPerformed(ActionEvent evt) {
        if (this.JCH13.isSelected()) {
            mAddElement(this.JCH13.getText(), 17L);
        } else {
            mRemoveElement(this.JCH13.getText(), 17L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIP18ActionPerformed(ActionEvent evt) {
        this.xP18 = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP18ActionPerformed(ActionEvent evt) {
        this.xP18 = "NO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH14ActionPerformed(ActionEvent evt) {
        if (this.JCH14.isSelected()) {
            mAddElement(this.JCH14.getText(), 19L);
        } else {
            mRemoveElement(this.JCH14.getText(), 19L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH15ActionPerformed(ActionEvent evt) {
        if (this.JCH15.isSelected()) {
            mAddElement(this.JCH15.getText(), 19L);
        } else {
            mRemoveElement(this.JCH15.getText(), 19L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH16ActionPerformed(ActionEvent evt) {
        if (this.JCH16.isSelected()) {
            mAddElement(this.JCH16.getText(), 19L);
        } else {
            mRemoveElement(this.JCH15.getText(), 19L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH17ActionPerformed(ActionEvent evt) {
        if (this.JCH17.isSelected()) {
            mAddElement(this.JCH17.getText(), 19L);
        } else {
            mRemoveElement(this.JCH17.getText(), 19L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH18ActionPerformed(ActionEvent evt) {
        if (this.JCH18.isSelected()) {
            mAddElement(this.JCH18.getText(), 19L);
        } else {
            mRemoveElement(this.JCH18.getText(), 19L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH19ActionPerformed(ActionEvent evt) {
        if (this.JCH19.isSelected()) {
            mAddElement(this.JCH19.getText(), 19L);
        } else {
            mRemoveElement(this.JCH19.getText(), 19L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH20ActionPerformed(ActionEvent evt) {
        if (this.JCH20.isSelected()) {
            mAddElement(this.JCH20.getText(), 19L);
        } else {
            mRemoveElement(this.JCH20.getText(), 19L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH21ActionPerformed(ActionEvent evt) {
        if (this.JCH21.isSelected()) {
            mAddElement(this.JCH21.getText(), 19L);
        } else {
            mRemoveElement(this.JCH21.getText(), 19L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH22ActionPerformed(ActionEvent evt) {
        if (this.JCH22.isSelected()) {
            mAddElement(this.JCH22.getText(), 19L);
        } else {
            mRemoveElement(this.JCH22.getText(), 19L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH23ActionPerformed(ActionEvent evt) {
        if (this.JCH23.isSelected()) {
            mAddElement(this.JCH23.getText(), 19L);
        } else {
            mRemoveElement(this.JCH23.getText(), 19L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH24ActionPerformed(ActionEvent evt) {
        if (this.JCH24.isSelected()) {
            mAddElement(this.JCH24.getText(), 19L);
        } else {
            mRemoveElement(this.JCH24.getText(), 19L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH25ActionPerformed(ActionEvent evt) {
        if (this.JCH25.isSelected()) {
            mAddElement(this.JCH25.getText(), 19L);
        } else {
            mRemoveElement(this.JCH25.getText(), 19L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH26ActionPerformed(ActionEvent evt) {
        if (this.JCH26.isSelected()) {
            mAddElement(this.JCH26.getText(), 19L);
        } else {
            mRemoveElement(this.JCH26.getText(), 19L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIP8ActionPerformed(ActionEvent evt) {
        this.xP4 = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP8ActionPerformed(ActionEvent evt) {
        this.xP4 = "NO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH27ActionPerformed(ActionEvent evt) {
        if (this.JCH27.isSelected()) {
            mAddElement(this.JCH27.getText(), 5L);
        } else {
            mRemoveElement(this.JCH27.getText(), 5L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH28ActionPerformed(ActionEvent evt) {
        if (this.JCH28.isSelected()) {
            mAddElement(this.JCH28.getText(), 5L);
        } else {
            mRemoveElement(this.JCH28.getText(), 5L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH29ActionPerformed(ActionEvent evt) {
        if (this.JCH29.isSelected()) {
            mAddElement(this.JCH29.getText(), 5L);
        } else {
            mRemoveElement(this.JCH29.getText(), 5L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIP14ActionPerformed(ActionEvent evt) {
        this.xP14 = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP14ActionPerformed(ActionEvent evt) {
        this.xP14 = "NO";
    }

    private void mAddElement(String x, long xp) {
        if (xp == 3) {
            this.xSeleccion3.addElement(x);
            mViewElements(xp);
            return;
        }
        if (xp == 5) {
            this.xSeleccion5.addElement(x);
            mViewElements(xp);
            return;
        }
        if (xp == 13) {
            this.xSeleccion13.addElement(x);
            mViewElements(xp);
            return;
        }
        if (xp == 16) {
            this.xSeleccion16.addElement(x);
            mViewElements(xp);
        } else if (xp == 17) {
            this.xSeleccion17.addElement(x);
            mViewElements(xp);
        } else if (xp == 19) {
            this.xSeleccion19.addElement(x);
            mViewElements(xp);
        }
    }

    private void mRemoveElement(String x, long xp) {
        if (xp == 3) {
            int i = 0;
            while (true) {
                if (i >= this.xSeleccion3.size()) {
                    break;
                }
                if (!x.equals(this.xSeleccion3.elementAt(i))) {
                    i++;
                } else {
                    this.xSeleccion3.removeElementAt(i);
                    break;
                }
            }
            mViewElements(xp);
            return;
        }
        if (xp == 5) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.xSeleccion5.size()) {
                    break;
                }
                if (!x.equals(this.xSeleccion5.elementAt(i2))) {
                    i2++;
                } else {
                    this.xSeleccion5.removeElementAt(i2);
                    break;
                }
            }
            mViewElements(xp);
            return;
        }
        if (xp == 13) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.xSeleccion13.size()) {
                    break;
                }
                if (!x.equals(this.xSeleccion13.elementAt(i3))) {
                    i3++;
                } else {
                    this.xSeleccion13.removeElementAt(i3);
                    break;
                }
            }
            mViewElements(xp);
            return;
        }
        if (xp == 16) {
            int i4 = 0;
            while (true) {
                if (i4 >= this.xSeleccion16.size()) {
                    break;
                }
                if (!x.equals(this.xSeleccion16.elementAt(i4))) {
                    i4++;
                } else {
                    this.xSeleccion16.removeElementAt(i4);
                    break;
                }
            }
            mViewElements(xp);
            return;
        }
        if (xp == 17) {
            int i5 = 0;
            while (true) {
                if (i5 >= this.xSeleccion17.size()) {
                    break;
                }
                if (!x.equals(this.xSeleccion17.elementAt(i5))) {
                    i5++;
                } else {
                    this.xSeleccion17.removeElementAt(i5);
                    break;
                }
            }
            mViewElements(xp);
            return;
        }
        if (xp == 19) {
            int i6 = 0;
            while (true) {
                if (i6 >= this.xSeleccion19.size()) {
                    break;
                }
                if (!x.equals(this.xSeleccion19.elementAt(i6))) {
                    i6++;
                } else {
                    this.xSeleccion19.removeElementAt(i6);
                    break;
                }
            }
            mViewElements(xp);
        }
    }

    private void mViewElements(long xp) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String resultado = "";
        if (xp == 3) {
            for (int i = 0; i < this.xSeleccion3.size(); i++) {
                if (resultado.equals("")) {
                    string6 = this.xSeleccion3.elementAt(i).toString();
                } else {
                    string6 = resultado + " , " + this.xSeleccion3.elementAt(i);
                }
                resultado = string6;
            }
            this.xP3 = resultado;
            return;
        }
        if (xp == 5) {
            for (int i2 = 0; i2 < this.xSeleccion5.size(); i2++) {
                if (resultado.equals("")) {
                    string5 = this.xSeleccion5.elementAt(i2).toString();
                } else {
                    string5 = resultado + " , " + this.xSeleccion5.elementAt(i2);
                }
                resultado = string5;
            }
            this.xP5 = resultado;
            return;
        }
        if (xp == 13) {
            for (int i3 = 0; i3 < this.xSeleccion13.size(); i3++) {
                if (resultado.equals("")) {
                    string4 = this.xSeleccion13.elementAt(i3).toString();
                } else {
                    string4 = resultado + " , " + this.xSeleccion13.elementAt(i3);
                }
                resultado = string4;
            }
            this.xP13 = resultado;
            return;
        }
        if (xp == 16) {
            for (int i4 = 0; i4 < this.xSeleccion16.size(); i4++) {
                if (resultado.equals("")) {
                    string3 = this.xSeleccion16.elementAt(i4).toString();
                } else {
                    string3 = resultado + " , " + this.xSeleccion16.elementAt(i4);
                }
                resultado = string3;
            }
            this.xP16 = resultado;
            return;
        }
        if (xp == 17) {
            for (int i5 = 0; i5 < this.xSeleccion17.size(); i5++) {
                if (resultado.equals("")) {
                    string2 = this.xSeleccion17.elementAt(i5).toString();
                } else {
                    string2 = resultado + " , " + this.xSeleccion17.elementAt(i5);
                }
                resultado = string2;
            }
            this.xP17 = resultado;
            return;
        }
        if (xp == 19) {
            for (int i6 = 0; i6 < this.xSeleccion19.size(); i6++) {
                if (resultado.equals("")) {
                    string = this.xSeleccion19.elementAt(i6).toString();
                } else {
                    string = resultado + " , " + this.xSeleccion19.elementAt(i6);
                }
                resultado = string;
            }
            this.xP19 = resultado;
        }
    }

    public void mGuardar(String xIdEva) {
        String sql = " insert into `p_aiepi_pj` ( `IdEva_AIEPI`, `P1`, `P2`,  `P3`, `P4`, `P5`, `P6`, `P7`, `P8`, `P9`, `P10`, `P11`, `P12`,   `P13`, `P14`, `P15`, `P16`, `P17`, `P18`, `P19`, `Observacion`, `UsuarioS`)  values ( '" + xIdEva + "',  '" + this.JTFP1.getText() + "', '" + this.xP2 + "', '" + this.xP3 + "', '" + this.xP4 + "', '" + this.xP5 + "', '" + this.JTFP2.getText() + "', '" + this.xP7 + "', '" + this.xP8 + "', '" + this.xP9 + "', '" + this.xP10 + "', '" + this.JTFP3.getText() + "', '" + this.JTFP4.getText() + "',  '" + this.xP13 + "', '" + this.xP14 + "', '" + this.JTFP5.getText() + "', '" + this.xP16 + "', '" + this.xP17 + "', '" + this.xP18 + "', '" + this.xP19 + "', '" + this.JTAObservacion.getText() + "', '" + Principal.usuarioSistemaDTO.getLogin() + "') ";
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
        for (int y = 0; y < this.JTDx.getRowCount(); y++) {
            if (Boolean.valueOf(this.xmodeloDx.getValueAt(y, 2).toString()).booleanValue()) {
                String sql2 = "INSERT INTO  `p_aiepi_dx_resultado` (`IdDx`, `IdEvaluacion`, `UsuarioS`) VALUES ('" + this.xmodeloDx.getValueAt(y, 0).toString() + "', '" + xIdEva + "', '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                this.xct.ejecutarSQL(sql2);
                this.xct.cerrarConexionBd();
            }
        }
    }
}
