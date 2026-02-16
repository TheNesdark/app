package Historia.aiepi;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
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

/* JADX INFO: loaded from: GenomaP.jar:Historia/aiepi/JPAiepi07.class */
public class JPAiepi07 extends JPanel {
    private DefaultTableModel xmodeloDx;
    private Object[] xdatos;
    private ButtonGroup JBGP1;
    private ButtonGroup JBGP10;
    private ButtonGroup JBGP11;
    private ButtonGroup JBGP12;
    private ButtonGroup JBGP13;
    private ButtonGroup JBGP2;
    private ButtonGroup JBGP3;
    private ButtonGroup JBGP4;
    private ButtonGroup JBGP5;
    private ButtonGroup JBGP6;
    private ButtonGroup JBGP7;
    private ButtonGroup JBGP8;
    private ButtonGroup JBGP9;
    private JRadioButton JRBNOP1;
    private JRadioButton JRBNOP10;
    private JRadioButton JRBNOP11;
    private JRadioButton JRBNOP12;
    private JRadioButton JRBNOP13;
    private JRadioButton JRBNOP2;
    private JRadioButton JRBNOP3;
    private JRadioButton JRBNOP4;
    private JRadioButton JRBNOP5;
    private JRadioButton JRBNOP6;
    private JRadioButton JRBNOP7;
    private JRadioButton JRBNOP8;
    private JRadioButton JRBNOP9;
    private JRadioButton JRBSIP1;
    private JRadioButton JRBSIP10;
    private JRadioButton JRBSIP11;
    private JRadioButton JRBSIP12;
    private JRadioButton JRBSIP13;
    private JRadioButton JRBSIP2;
    private JRadioButton JRBSIP3;
    private JRadioButton JRBSIP4;
    private JRadioButton JRBSIP5;
    private JRadioButton JRBSIP6;
    private JRadioButton JRBSIP7;
    private JRadioButton JRBSIP8;
    private JRadioButton JRBSIP9;
    private JScrollPane JSPDiagnosticos;
    private JTextArea JTAObservacion;
    private JTable JTDx;
    private JTextField JTFDias;
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
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel3;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xP1 = "NO";
    private String xP2 = "NO";
    private String xP3 = "NO";
    private String xP4 = "NO";
    private String xP5 = "NO";
    private String xP6 = "NO";
    private String xP7 = "NO";
    private String xP8 = "NO";
    private String xP9 = "NO";
    private String xP10 = "NO";
    private String xP11 = "NO";
    private String xP12 = "NO";
    private String xP13 = "NO";

    public JPAiepi07(int x) {
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
        this.xmodeloDx = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Aplica?"}) { // from class: Historia.aiepi.JPAiepi07.1
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

    /* JADX WARN: Type inference failed for: r3v143, types: [java.lang.Object[], java.lang.Object[][]] */
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
        this.JBGP11 = new ButtonGroup();
        this.JBGP12 = new ButtonGroup();
        this.JBGP13 = new ButtonGroup();
        this.jScrollPane1 = new JScrollPane();
        this.jPanel2 = new JPanel();
        this.jPanel1 = new JPanel();
        this.jLabel9 = new JLabel();
        this.JRBSIP1 = new JRadioButton();
        this.JRBNOP1 = new JRadioButton();
        this.jLabel10 = new JLabel();
        this.JRBSIP2 = new JRadioButton();
        this.JRBNOP2 = new JRadioButton();
        this.jLabel11 = new JLabel();
        this.JRBSIP3 = new JRadioButton();
        this.JRBNOP3 = new JRadioButton();
        this.jLabel12 = new JLabel();
        this.JRBSIP4 = new JRadioButton();
        this.JRBNOP4 = new JRadioButton();
        this.jLabel13 = new JLabel();
        this.JRBSIP5 = new JRadioButton();
        this.JRBNOP5 = new JRadioButton();
        this.jLabel14 = new JLabel();
        this.JRBNOP6 = new JRadioButton();
        this.jLabel15 = new JLabel();
        this.JRBSIP6 = new JRadioButton();
        this.jLabel16 = new JLabel();
        this.JRBSIP7 = new JRadioButton();
        this.JRBNOP7 = new JRadioButton();
        this.jLabel17 = new JLabel();
        this.jLabel18 = new JLabel();
        this.JRBSIP8 = new JRadioButton();
        this.JRBNOP8 = new JRadioButton();
        this.jLabel19 = new JLabel();
        this.JRBSIP9 = new JRadioButton();
        this.JRBNOP9 = new JRadioButton();
        this.jLabel20 = new JLabel();
        this.jLabel21 = new JLabel();
        this.JRBSIP10 = new JRadioButton();
        this.JRBNOP10 = new JRadioButton();
        this.jLabel22 = new JLabel();
        this.JRBSIP11 = new JRadioButton();
        this.JRBNOP11 = new JRadioButton();
        this.jLabel23 = new JLabel();
        this.JRBSIP12 = new JRadioButton();
        this.JRBNOP12 = new JRadioButton();
        this.jLabel24 = new JLabel();
        this.JRBSIP13 = new JRadioButton();
        this.JRBNOP13 = new JRadioButton();
        this.jLabel3 = new JLabel();
        this.JTFDias = new JTextField();
        this.JSPDiagnosticos = new JScrollPane();
        this.JTDx = new JTable();
        this.jScrollPane2 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel9.setFont(new Font("Arial", 1, 12));
        this.jLabel9.setText("¿Tiene dolor al comer-masticar?");
        this.JBGP1.add(this.JRBSIP1);
        this.JRBSIP1.setFont(new Font("Arial", 1, 12));
        this.JRBSIP1.setForeground(Color.red);
        this.JRBSIP1.setText("SI");
        this.JRBSIP1.setHorizontalTextPosition(2);
        this.JRBSIP1.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.2
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBSIP1ActionPerformed(evt);
            }
        });
        this.JBGP1.add(this.JRBNOP1);
        this.JRBNOP1.setFont(new Font("Arial", 1, 12));
        this.JRBNOP1.setForeground(Color.red);
        this.JRBNOP1.setSelected(true);
        this.JRBNOP1.setText("NO");
        this.JRBNOP1.setHorizontalTextPosition(2);
        this.JRBNOP1.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.3
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBNOP1ActionPerformed(evt);
            }
        });
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setText("¿Tiene dolor en diente?");
        this.JBGP2.add(this.JRBSIP2);
        this.JRBSIP2.setFont(new Font("Arial", 1, 12));
        this.JRBSIP2.setForeground(Color.red);
        this.JRBSIP2.setText("SI");
        this.JRBSIP2.setHorizontalTextPosition(2);
        this.JRBSIP2.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.4
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBSIP2ActionPerformed(evt);
            }
        });
        this.JBGP2.add(this.JRBNOP2);
        this.JRBNOP2.setFont(new Font("Arial", 1, 12));
        this.JRBNOP2.setForeground(Color.red);
        this.JRBNOP2.setSelected(true);
        this.JRBNOP2.setText("NO");
        this.JRBNOP2.setHorizontalTextPosition(2);
        this.JRBNOP2.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.5
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBNOP2ActionPerformed(evt);
            }
        });
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setText("¿Trauma en cara o boca?");
        this.JBGP3.add(this.JRBSIP3);
        this.JRBSIP3.setFont(new Font("Arial", 1, 12));
        this.JRBSIP3.setForeground(Color.red);
        this.JRBSIP3.setText("SI");
        this.JRBSIP3.setHorizontalTextPosition(2);
        this.JRBSIP3.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.6
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBSIP3ActionPerformed(evt);
            }
        });
        this.JBGP3.add(this.JRBNOP3);
        this.JRBNOP3.setFont(new Font("Arial", 1, 12));
        this.JRBNOP3.setForeground(Color.red);
        this.JRBNOP3.setSelected(true);
        this.JRBNOP3.setText("NO");
        this.JRBNOP3.setHorizontalTextPosition(2);
        this.JRBNOP3.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.7
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBNOP3ActionPerformed(evt);
            }
        });
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setText("¿Tienen padres/hermanos caries?");
        this.JBGP4.add(this.JRBSIP4);
        this.JRBSIP4.setFont(new Font("Arial", 1, 12));
        this.JRBSIP4.setForeground(Color.red);
        this.JRBSIP4.setText("SI");
        this.JRBSIP4.setHorizontalTextPosition(2);
        this.JRBSIP4.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.8
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBSIP4ActionPerformed(evt);
            }
        });
        this.JBGP4.add(this.JRBNOP4);
        this.JRBNOP4.setFont(new Font("Arial", 1, 12));
        this.JRBNOP4.setForeground(Color.red);
        this.JRBNOP4.setSelected(true);
        this.JRBNOP4.setText("NO");
        this.JRBNOP4.setHorizontalTextPosition(2);
        this.JRBNOP4.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.9
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBNOP4ActionPerformed(evt);
            }
        });
        this.jLabel13.setFont(new Font("Arial", 1, 12));
        this.jLabel13.setText("Mañana:");
        this.JBGP5.add(this.JRBSIP5);
        this.JRBSIP5.setFont(new Font("Arial", 1, 12));
        this.JRBSIP5.setForeground(Color.red);
        this.JRBSIP5.setText("SI");
        this.JRBSIP5.setHorizontalTextPosition(2);
        this.JRBSIP5.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.10
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBSIP5ActionPerformed(evt);
            }
        });
        this.JBGP5.add(this.JRBNOP5);
        this.JRBNOP5.setFont(new Font("Arial", 1, 12));
        this.JRBNOP5.setForeground(Color.red);
        this.JRBNOP5.setSelected(true);
        this.JRBNOP5.setText("NO");
        this.JRBNOP5.setHorizontalTextPosition(2);
        this.JRBNOP5.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.11
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBNOP5ActionPerformed(evt);
            }
        });
        this.jLabel14.setFont(new Font("Arial", 1, 12));
        this.jLabel14.setText("¿Cuándo le limpia boca?");
        this.JBGP6.add(this.JRBNOP6);
        this.JRBNOP6.setFont(new Font("Arial", 1, 12));
        this.JRBNOP6.setForeground(Color.red);
        this.JRBNOP6.setSelected(true);
        this.JRBNOP6.setText("NO");
        this.JRBNOP6.setHorizontalTextPosition(2);
        this.JRBNOP6.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.12
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBNOP6ActionPerformed(evt);
            }
        });
        this.jLabel15.setFont(new Font("Arial", 1, 12));
        this.jLabel15.setText("Medio día:");
        this.JBGP6.add(this.JRBSIP6);
        this.JRBSIP6.setFont(new Font("Arial", 1, 12));
        this.JRBSIP6.setForeground(Color.red);
        this.JRBSIP6.setText("SI");
        this.JRBSIP6.setHorizontalTextPosition(2);
        this.JRBSIP6.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.13
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBSIP6ActionPerformed(evt);
            }
        });
        this.jLabel16.setFont(new Font("Arial", 1, 12));
        this.jLabel16.setText("Noche:");
        this.JBGP7.add(this.JRBSIP7);
        this.JRBSIP7.setFont(new Font("Arial", 1, 12));
        this.JRBSIP7.setForeground(Color.red);
        this.JRBSIP7.setText("SI");
        this.JRBSIP7.setHorizontalTextPosition(2);
        this.JRBSIP7.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.14
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBSIP7ActionPerformed(evt);
            }
        });
        this.JBGP7.add(this.JRBNOP7);
        this.JRBNOP7.setFont(new Font("Arial", 1, 12));
        this.JRBNOP7.setForeground(Color.red);
        this.JRBNOP7.setSelected(true);
        this.JRBNOP7.setText("NO");
        this.JRBNOP7.setHorizontalTextPosition(2);
        this.JRBNOP7.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.15
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBNOP7ActionPerformed(evt);
            }
        });
        this.jLabel17.setFont(new Font("Arial", 1, 12));
        this.jLabel17.setText("¿Cómo supervisa limpieza?");
        this.jLabel18.setFont(new Font("Arial", 1, 12));
        this.jLabel18.setText("Le limpia los Dientes:");
        this.JBGP8.add(this.JRBSIP8);
        this.JRBSIP8.setFont(new Font("Arial", 1, 12));
        this.JRBSIP8.setForeground(Color.red);
        this.JRBSIP8.setText("SI");
        this.JRBSIP8.setHorizontalTextPosition(2);
        this.JRBSIP8.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.16
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBSIP8ActionPerformed(evt);
            }
        });
        this.JBGP8.add(this.JRBNOP8);
        this.JRBNOP8.setFont(new Font("Arial", 1, 12));
        this.JRBNOP8.setForeground(Color.red);
        this.JRBNOP8.setSelected(true);
        this.JRBNOP8.setText("NO");
        this.JRBNOP8.setHorizontalTextPosition(2);
        this.JRBNOP8.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.17
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBNOP8ActionPerformed(evt);
            }
        });
        this.jLabel19.setFont(new Font("Arial", 1, 12));
        this.jLabel19.setText("Niño solo:");
        this.JBGP9.add(this.JRBSIP9);
        this.JRBSIP9.setFont(new Font("Arial", 1, 12));
        this.JRBSIP9.setForeground(Color.red);
        this.JRBSIP9.setText("SI");
        this.JRBSIP9.setHorizontalTextPosition(2);
        this.JRBSIP9.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.18
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBSIP9ActionPerformed(evt);
            }
        });
        this.JBGP9.add(this.JRBNOP9);
        this.JRBNOP9.setFont(new Font("Arial", 1, 12));
        this.JRBNOP9.setForeground(Color.red);
        this.JRBNOP9.setSelected(true);
        this.JRBNOP9.setText("NO");
        this.JRBNOP9.setHorizontalTextPosition(2);
        this.JRBNOP9.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.19
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBNOP9ActionPerformed(evt);
            }
        });
        this.jLabel20.setFont(new Font("Arial", 1, 12));
        this.jLabel20.setText("¿Qué utiliza?");
        this.jLabel21.setFont(new Font("Arial", 1, 12));
        this.jLabel21.setText("Cepillo:");
        this.JBGP10.add(this.JRBSIP10);
        this.JRBSIP10.setFont(new Font("Arial", 1, 12));
        this.JRBSIP10.setForeground(Color.red);
        this.JRBSIP10.setText("SI");
        this.JRBSIP10.setHorizontalTextPosition(2);
        this.JRBSIP10.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.20
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBSIP10ActionPerformed(evt);
            }
        });
        this.JBGP10.add(this.JRBNOP10);
        this.JRBNOP10.setFont(new Font("Arial", 1, 12));
        this.JRBNOP10.setForeground(Color.red);
        this.JRBNOP10.setSelected(true);
        this.JRBNOP10.setText("NO");
        this.JRBNOP10.setHorizontalTextPosition(2);
        this.JRBNOP10.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.21
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBNOP10ActionPerformed(evt);
            }
        });
        this.jLabel22.setFont(new Font("Arial", 1, 12));
        this.jLabel22.setText("Crema:");
        this.JBGP11.add(this.JRBSIP11);
        this.JRBSIP11.setFont(new Font("Arial", 1, 12));
        this.JRBSIP11.setForeground(Color.red);
        this.JRBSIP11.setText("SI");
        this.JRBSIP11.setHorizontalTextPosition(2);
        this.JRBSIP11.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.22
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBSIP11ActionPerformed(evt);
            }
        });
        this.JBGP11.add(this.JRBNOP11);
        this.JRBNOP11.setFont(new Font("Arial", 1, 12));
        this.JRBNOP11.setForeground(Color.red);
        this.JRBNOP11.setSelected(true);
        this.JRBNOP11.setText("NO");
        this.JRBNOP11.setHorizontalTextPosition(2);
        this.JRBNOP11.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.23
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBNOP11ActionPerformed(evt);
            }
        });
        this.jLabel23.setFont(new Font("Arial", 1, 12));
        this.jLabel23.setText("Seda:");
        this.JBGP12.add(this.JRBSIP12);
        this.JRBSIP12.setFont(new Font("Arial", 1, 12));
        this.JRBSIP12.setForeground(Color.red);
        this.JRBSIP12.setText("SI");
        this.JRBSIP12.setHorizontalTextPosition(2);
        this.JRBSIP12.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.24
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBSIP12ActionPerformed(evt);
            }
        });
        this.JBGP12.add(this.JRBNOP12);
        this.JRBNOP12.setFont(new Font("Arial", 1, 12));
        this.JRBNOP12.setForeground(Color.red);
        this.JRBNOP12.setSelected(true);
        this.JRBNOP12.setText("NO");
        this.JRBNOP12.setHorizontalTextPosition(2);
        this.JRBNOP12.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.25
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBNOP12ActionPerformed(evt);
            }
        });
        this.jLabel24.setFont(new Font("Arial", 1, 12));
        this.jLabel24.setText("¿Utiliza chupo o biberón?");
        this.JBGP13.add(this.JRBSIP13);
        this.JRBSIP13.setFont(new Font("Arial", 1, 12));
        this.JRBSIP13.setForeground(Color.red);
        this.JRBSIP13.setText("SI");
        this.JRBSIP13.setHorizontalTextPosition(2);
        this.JRBSIP13.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.26
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBSIP13ActionPerformed(evt);
            }
        });
        this.JBGP13.add(this.JRBNOP13);
        this.JRBNOP13.setFont(new Font("Arial", 1, 12));
        this.JRBNOP13.setForeground(Color.red);
        this.JRBNOP13.setSelected(true);
        this.JRBNOP13.setText("NO");
        this.JRBNOP13.setHorizontalTextPosition(2);
        this.JRBNOP13.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi07.27
            public void actionPerformed(ActionEvent evt) {
                JPAiepi07.this.JRBNOP13ActionPerformed(evt);
            }
        });
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setText("¿Cuándo fue la última consulta odontológica:");
        this.JTFDias.setToolTipText("En número");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel9, -2, 220, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSIP1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP1)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel10, -2, 220, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSIP2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel11, -2, 220, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSIP3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP3)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel12, -2, 220, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSIP4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP4)).addComponent(this.jLabel14, -2, 220, -2)).addGap(0, 0, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel3, -2, 263, -2).addComponent(this.jLabel24)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFDias, -2, 47, -2)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel13, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSIP5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP5).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel15, -2, 58, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSIP6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP6).addGap(12, 12, 12).addComponent(this.jLabel16, -2, 46, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSIP7).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP7)).addComponent(this.jLabel17, -2, 220, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel18).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSIP8).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP8).addGap(8, 8, 8).addComponent(this.jLabel19).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSIP9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP9)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JRBSIP13).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNOP13)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel20, -2, 79, -2).addGap(2, 2, 2).addComponent(this.jLabel21).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSIP10).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP10).addGap(2, 2, 2).addComponent(this.jLabel22))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSIP11).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP11).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel23).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSIP12).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP12))).addGap(2, 2, 2)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel9).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP1, -2, 13, -2).addComponent(this.JRBNOP1, GroupLayout.Alignment.LEADING, -2, 13, -2))).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel10).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP2, -2, 13, -2).addComponent(this.JRBNOP2, GroupLayout.Alignment.LEADING, -2, 13, -2))).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel11).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP3, -2, 13, -2).addComponent(this.JRBNOP3, GroupLayout.Alignment.LEADING, -2, 13, -2))).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel12).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP4, -2, 13, -2).addComponent(this.JRBNOP4, GroupLayout.Alignment.LEADING, -2, 13, -2))).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel14).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel13).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP5, -2, 13, -2).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNOP5, -2, 13, -2).addComponent(this.jLabel15))).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP6, -2, 13, -2).addComponent(this.JRBNOP6, GroupLayout.Alignment.LEADING, -2, 13, -2)))).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSIP7, -2, 13, -2).addComponent(this.jLabel16)).addComponent(this.JRBNOP7, GroupLayout.Alignment.LEADING, -2, 13, -2))).addGap(4, 4, 4).addComponent(this.jLabel17).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP8, -2, 13, -2).addComponent(this.JRBNOP8, GroupLayout.Alignment.LEADING, -2, 13, -2)).addComponent(this.jLabel19).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP9, -2, 13, -2).addComponent(this.JRBNOP9, GroupLayout.Alignment.LEADING, -2, 13, -2))).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel23).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP12, -2, 13, -2).addComponent(this.JRBNOP12, GroupLayout.Alignment.LEADING, -2, 13, -2)).addComponent(this.jLabel20).addComponent(this.jLabel21).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP10, -2, 13, -2).addComponent(this.JRBNOP10, GroupLayout.Alignment.LEADING, -2, 13, -2)).addComponent(this.jLabel22).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP11, -2, 13, -2).addComponent(this.JRBNOP11, GroupLayout.Alignment.LEADING, -2, 13, -2))).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSIP13, -2, 13, -2).addComponent(this.JRBNOP13, -2, 13, -2)).addComponent(this.jLabel24)).addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.JTFDias, -2, -1, -2)).addContainerGap(-1, 32767)));
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
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jPanel1, -2, -1, -2).addGap(3, 3, 3).addComponent(this.JSPDiagnosticos, -1, 309, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2))).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.JSPDiagnosticos, -2, 0, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -1, 86, 32767).addContainerGap()));
        this.jScrollPane1.setViewportView(this.jPanel2);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jScrollPane1).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1).addGap(3, 3, 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIP1ActionPerformed(ActionEvent evt) {
        this.xP1 = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP1ActionPerformed(ActionEvent evt) {
        this.xP1 = "NO";
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
        this.xP6 = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP6ActionPerformed(ActionEvent evt) {
        this.xP6 = "NO";
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
    public void JRBSIP8ActionPerformed(ActionEvent evt) {
        this.xP8 = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP8ActionPerformed(ActionEvent evt) {
        this.xP8 = "NO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIP9ActionPerformed(ActionEvent evt) {
        this.xP9 = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP9ActionPerformed(ActionEvent evt) {
        this.xP9 = "NO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIP10ActionPerformed(ActionEvent evt) {
        this.xP10 = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP10ActionPerformed(ActionEvent evt) {
        this.xP10 = "NO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIP11ActionPerformed(ActionEvent evt) {
        this.xP11 = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP11ActionPerformed(ActionEvent evt) {
        this.xP11 = "NO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIP12ActionPerformed(ActionEvent evt) {
        this.xP12 = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP12ActionPerformed(ActionEvent evt) {
        this.xP12 = "NO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIP13ActionPerformed(ActionEvent evt) {
        this.xP13 = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP13ActionPerformed(ActionEvent evt) {
        this.xP13 = "NO";
    }

    public void mGuardar(String xidExamen) {
        String sql = "INSERT INTO `p_aiepi_pg` ( `IdEva_AIEPI`, `P1`, `P2`, `P3`, `P4`,  `P5`, `P6`, `P7`, `P8`, `P9`, `P10`, `P11`, `P12`, `P13`, `P14`, `Observacion`, UsuarioS)VALUES ( '" + xidExamen + "', '" + this.xP1 + "', '" + this.xP2 + "', '" + this.xP3 + "', '" + this.xP4 + "', '" + this.xP5 + "', '" + this.xP6 + "', '" + this.xP7 + "', '" + this.xP8 + "', '" + this.xP9 + "', '" + this.xP10 + "', '" + this.xP11 + "', '" + this.xP12 + "', '" + this.xP13 + "', '" + this.JTFDias.getText() + "', '" + this.JTAObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "') ";
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
