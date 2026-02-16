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

/* JADX INFO: loaded from: GenomaP.jar:Historia/aiepi/JPAiepi03.class */
public class JPAiepi03 extends JPanel {
    private DefaultTableModel xmodeloDx;
    private Object[] xdatos;
    private int x;
    private JCheckBox JCH1;
    private JCheckBox JCH2;
    private JCheckBox JCH3;
    private JCheckBox JCH4;
    private JCheckBox JCH5;
    private JRadioButton JRB1;
    private JRadioButton JRB2;
    private JRadioButton JRB3;
    private ButtonGroup JRBGP0;
    private ButtonGroup JRBGP2;
    private ButtonGroup JRBGP3;
    private ButtonGroup JRBGP6;
    private JRadioButton JRBNO;
    private JRadioButton JRBNOP2;
    private JRadioButton JRBNOP3;
    private JRadioButton JRBSI;
    private JRadioButton JRBSIP2;
    private JRadioButton JRBSIP3;
    private JScrollPane JSPDiagnosticos;
    private JTextArea JTAObservacion;
    private JTable JTDx;
    private JTextField JTFDiarrea24;
    private JTextField JTFDiarrea4;
    private JTextField JTFDias;
    private JTextField JTFVomito4;
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
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String xP0 = "NO";
    private String xP2 = "NO";
    private String xP3 = "NO";
    private String xP7 = "";
    private String xP8 = "";
    public Vector xSeleccion = new Vector();

    public JPAiepi03(int x) {
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
        this.xmodeloDx = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Aplica?"}) { // from class: Historia.aiepi.JPAiepi03.1
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

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JRBGP0 = new ButtonGroup();
        this.JRBGP6 = new ButtonGroup();
        this.JRBGP2 = new ButtonGroup();
        this.JRBGP3 = new ButtonGroup();
        this.JSPDiagnosticos = new JScrollPane();
        this.JTDx = new JTable();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.JRBSI = new JRadioButton();
        this.JRBNO = new JRadioButton();
        this.jPanel1 = new JPanel();
        this.jLabel5 = new JLabel();
        this.JRBSIP2 = new JRadioButton();
        this.JRBNOP2 = new JRadioButton();
        this.jLabel6 = new JLabel();
        this.JRBSIP3 = new JRadioButton();
        this.JRBNOP3 = new JRadioButton();
        this.jLabel3 = new JLabel();
        this.JTFDias = new JTextField();
        this.jLabel4 = new JLabel();
        this.jLabel7 = new JLabel();
        this.JTFVomito4 = new JTextField();
        this.jLabel8 = new JLabel();
        this.JTFDiarrea24 = new JTextField();
        this.jLabel9 = new JLabel();
        this.JTFDiarrea4 = new JTextField();
        this.jPanel2 = new JPanel();
        this.JCH1 = new JCheckBox();
        this.JCH2 = new JCheckBox();
        this.JCH3 = new JCheckBox();
        this.JCH4 = new JCheckBox();
        this.JCH5 = new JCheckBox();
        this.jLabel10 = new JLabel();
        this.JRB1 = new JRadioButton();
        this.JRB2 = new JRadioButton();
        this.JRB3 = new JRadioButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JSPDiagnosticos.setBorder(BorderFactory.createTitledBorder((Border) null, "Diagnósticos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTDx.setFont(new Font("Arial", 1, 12));
        this.JTDx.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDx.setSelectionBackground(new Color(255, 255, 255));
        this.JTDx.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDiagnosticos.setViewportView(this.JTDx);
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("¿TIENE DIARREA?");
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText(" SI       NO");
        this.JRBGP0.add(this.JRBSI);
        this.JRBSI.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi03.2
            public void actionPerformed(ActionEvent evt) {
                JPAiepi03.this.JRBSIActionPerformed(evt);
            }
        });
        this.JRBGP0.add(this.JRBNO);
        this.JRBNO.setSelected(true);
        this.JRBNO.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi03.3
            public void actionPerformed(ActionEvent evt) {
                JPAiepi03.this.JRBNOActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setText("¿Hay sangre en las heces?");
        this.JRBGP2.add(this.JRBSIP2);
        this.JRBSIP2.setFont(new Font("Arial", 1, 12));
        this.JRBSIP2.setForeground(Color.red);
        this.JRBSIP2.setText("SI");
        this.JRBSIP2.setHorizontalTextPosition(2);
        this.JRBSIP2.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi03.4
            public void actionPerformed(ActionEvent evt) {
                JPAiepi03.this.JRBSIP2ActionPerformed(evt);
            }
        });
        this.JRBGP2.add(this.JRBNOP2);
        this.JRBNOP2.setFont(new Font("Arial", 1, 12));
        this.JRBNOP2.setForeground(Color.red);
        this.JRBNOP2.setSelected(true);
        this.JRBNOP2.setText("NO");
        this.JRBNOP2.setHorizontalTextPosition(2);
        this.JRBNOP2.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi03.5
            public void actionPerformed(ActionEvent evt) {
                JPAiepi03.this.JRBNOP2ActionPerformed(evt);
            }
        });
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setText("¿Tiene vómito?");
        this.JRBGP3.add(this.JRBSIP3);
        this.JRBSIP3.setFont(new Font("Arial", 1, 12));
        this.JRBSIP3.setForeground(Color.red);
        this.JRBSIP3.setText("SI");
        this.JRBSIP3.setHorizontalTextPosition(2);
        this.JRBSIP3.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi03.6
            public void actionPerformed(ActionEvent evt) {
                JPAiepi03.this.JRBSIP3ActionPerformed(evt);
            }
        });
        this.JRBGP3.add(this.JRBNOP3);
        this.JRBNOP3.setFont(new Font("Arial", 1, 12));
        this.JRBNOP3.setForeground(Color.red);
        this.JRBNOP3.setSelected(true);
        this.JRBNOP3.setText("NO");
        this.JRBNOP3.setHorizontalTextPosition(2);
        this.JRBNOP3.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi03.7
            public void actionPerformed(ActionEvent evt) {
                JPAiepi03.this.JRBNOP3ActionPerformed(evt);
            }
        });
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setText("Hace cuanto tiempo?");
        this.JTFDias.setToolTipText("En número");
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setText("días");
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setText("# Vómitos en las últimas 4h.");
        this.JTFVomito4.setToolTipText("En número");
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setText("#Diarreas en las últimas 24 h");
        this.JTFDiarrea24.setToolTipText("En número");
        this.jLabel9.setFont(new Font("Arial", 1, 12));
        this.jLabel9.setText("#Diarreas en las últimas 4 h.");
        this.JTFDiarrea4.setToolTipText("En número");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jLabel3, -2, 145, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDias, -2, 47, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel4, -2, 145, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel5, -2, 183, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSIP2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP2)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel7, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFVomito4, -2, 47, -2)).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel6, -2, 183, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSIP3))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP3)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel8, -2, 169, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDiarrea24, -2, 47, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel9, -2, 169, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDiarrea4, -2, 47, -2))).addGap(0, 0, 32767))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.JTFDias, -2, -1, -2).addComponent(this.jLabel4)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP2, -2, 13, -2).addComponent(this.JRBNOP2, GroupLayout.Alignment.LEADING, -2, 13, -2))).addGap(8, 8, 8).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel6).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP3, -2, 13, -2).addComponent(this.JRBNOP3, GroupLayout.Alignment.LEADING, -2, 13, -2))).addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.JTFVomito4, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel8).addComponent(this.JTFDiarrea24, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel9).addComponent(this.JTFDiarrea4, -2, -1, -2)).addGap(5, 5, 5)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder(""));
        this.JCH1.setFont(new Font("Arial", 1, 12));
        this.JCH1.setText("Letárgico o comatoso");
        this.JCH1.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi03.8
            public void actionPerformed(ActionEvent evt) {
                JPAiepi03.this.JCH1ActionPerformed(evt);
            }
        });
        this.JCH2.setFont(new Font("Arial", 1, 12));
        this.JCH2.setText("Intranquilo o irritable");
        this.JCH2.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi03.9
            public void actionPerformed(ActionEvent evt) {
                JPAiepi03.this.JCH2ActionPerformed(evt);
            }
        });
        this.JCH3.setFont(new Font("Arial", 1, 12));
        this.JCH3.setText("Ojos Hundidos");
        this.JCH3.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi03.10
            public void actionPerformed(ActionEvent evt) {
                JPAiepi03.this.JCH3ActionPerformed(evt);
            }
        });
        this.JCH4.setFont(new Font("Arial", 1, 12));
        this.JCH4.setText("Bebe mal o no puede beber");
        this.JCH4.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi03.11
            public void actionPerformed(ActionEvent evt) {
                JPAiepi03.this.JCH4ActionPerformed(evt);
            }
        });
        this.JCH5.setFont(new Font("Arial", 1, 12));
        this.JCH5.setText("Bebe ávidamente con sed");
        this.JCH5.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi03.12
            public void actionPerformed(ActionEvent evt) {
                JPAiepi03.this.JCH5ActionPerformed(evt);
            }
        });
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setText("Pliegue cutáneo");
        this.JRBGP6.add(this.JRB1);
        this.JRB1.setFont(new Font("Arial", 1, 12));
        this.JRB1.setText("Inmediato");
        this.JRB1.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi03.13
            public void actionPerformed(ActionEvent evt) {
                JPAiepi03.this.JRB1ActionPerformed(evt);
            }
        });
        this.JRBGP6.add(this.JRB2);
        this.JRB2.setFont(new Font("Arial", 1, 12));
        this.JRB2.setText("Lento");
        this.JRB2.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi03.14
            public void actionPerformed(ActionEvent evt) {
                JPAiepi03.this.JRB2ActionPerformed(evt);
            }
        });
        this.JRBGP6.add(this.JRB3);
        this.JRB3.setFont(new Font("Arial", 1, 12));
        this.JRB3.setText("Muy Lento");
        this.JRB3.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi03.15
            public void actionPerformed(ActionEvent evt) {
                JPAiepi03.this.JRB3ActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCH4).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB3)).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH1).addComponent(this.JCH2).addComponent(this.JCH3)).addGap(31, 31, 31).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JRB1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB2)).addComponent(this.jLabel10).addComponent(this.JCH5)))).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH1).addComponent(this.JCH5)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH2).addComponent(this.jLabel10)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH3).addComponent(this.JRB1).addComponent(this.JRB2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH4).addComponent(this.JRB3))));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 0, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAObservacion);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1, -2, 316, -2).addGap(8, 8, 8).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JRBSI).addGap(10, 10, 10).addComponent(this.JRBNO)).addComponent(this.jLabel2))).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDiagnosticos, -1, 312, 32767).addComponent(this.jScrollPane1)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBSI).addComponent(this.JRBNO))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2)).addComponent(this.JSPDiagnosticos, -2, 188, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jScrollPane1)).addContainerGap(12, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIActionPerformed(ActionEvent evt) {
        this.xP0 = "SI";
        mIniciaComponentes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOActionPerformed(ActionEvent evt) {
        mIniciaComponentes();
        mBuscarTablaDx(this.x);
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
    public void JRB1ActionPerformed(ActionEvent evt) {
        this.xP8 = this.JRB1.getText();
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
    public void JRB2ActionPerformed(ActionEvent evt) {
        this.xP8 = this.JRB2.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB3ActionPerformed(ActionEvent evt) {
        this.xP8 = this.JRB3.getText();
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
        this.xP0 = "NO";
        this.xP2 = "NO";
        this.xP3 = "NO";
        this.xP7 = "";
        this.xP8 = "";
        this.JRBGP2.clearSelection();
        this.JRBGP3.clearSelection();
        this.JRBGP6.clearSelection();
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
        this.xP7 = resultado;
    }

    public void mGuardar(String xidExamen) {
        String sql = "INSERT INTO `p_aiepi_pc` ( `IdEva_AIEPI`, `P0`, `P1`, `P2`,  `P3`, `P4`, `P5`, `P6`, `P7`, `P8`, `Observacion`,  `UsuarioS`) VALUES ( '" + xidExamen + "', '" + this.xP0 + "', '" + this.JTFDias.getText() + "', '" + this.xP2 + "', '" + this.xP3 + "', '" + this.JTFVomito4.getText() + "', '" + this.JTFDiarrea24.getText() + "', '" + this.JTFDiarrea4.getText() + "', '" + this.xP7 + "', '" + this.xP8 + "', '" + this.JTAObservacion.getText() + "', '" + Principal.usuarioSistemaDTO.getLogin() + "') ";
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
