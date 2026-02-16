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

/* JADX INFO: loaded from: GenomaP.jar:Historia/aiepi/JPAiepi02.class */
public class JPAiepi02 extends JPanel {
    private DefaultTableModel xmodeloDx;
    private Object[] xdatos;
    private int x;
    private ButtonGroup JGRBP0;
    private ButtonGroup JGRBP2;
    private ButtonGroup JGRBP3;
    private ButtonGroup JGRBP4;
    private ButtonGroup JGRBP5;
    private JRadioButton JRBNO;
    private JRadioButton JRBNOP2;
    private JRadioButton JRBNOP3;
    private JRadioButton JRBNOP4;
    private JRadioButton JRBNOP5;
    private JRadioButton JRBSI;
    private JRadioButton JRBSIP2;
    private JRadioButton JRBSIP3;
    private JRadioButton JRBSIP4;
    private JRadioButton JRBSIP5;
    private JScrollPane JSPDiagnosticos;
    private JTextArea JTAObservacion;
    private JTable JTDx;
    private JTextField JTFDias;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xP0 = "NO";
    private String xP1 = "";
    private String xP2 = "NO";
    private String xP3 = "NO";
    private String xP4 = "NO";
    private String xP5 = "NO";

    public JPAiepi02(int x) {
        this.x = x;
        initComponents();
        mBuscarTablaDx(x);
        mIniciarElementos();
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
        this.xmodeloDx = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Aplica?"}) { // from class: Historia.aiepi.JPAiepi02.1
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
        this.JGRBP0 = new ButtonGroup();
        this.JGRBP2 = new ButtonGroup();
        this.JGRBP3 = new ButtonGroup();
        this.JGRBP4 = new ButtonGroup();
        this.JGRBP5 = new ButtonGroup();
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
        this.jLabel7 = new JLabel();
        this.JRBSIP4 = new JRadioButton();
        this.JRBNOP4 = new JRadioButton();
        this.jLabel8 = new JLabel();
        this.JRBSIP5 = new JRadioButton();
        this.JRBNOP5 = new JRadioButton();
        this.jLabel3 = new JLabel();
        this.JTFDias = new JTextField();
        this.jLabel4 = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JSPDiagnosticos.setBorder(BorderFactory.createTitledBorder((Border) null, "Diagnósticos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTDx.setFont(new Font("Arial", 1, 12));
        this.JTDx.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDx.setSelectionBackground(new Color(255, 255, 255));
        this.JTDx.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDiagnosticos.setViewportView(this.JTDx);
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("TIENE TOS O DIFICULTAD PARA RESPIRAR?");
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText(" SI       NO");
        this.JGRBP0.add(this.JRBSI);
        this.JRBSI.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi02.2
            public void actionPerformed(ActionEvent evt) {
                JPAiepi02.this.JRBSIActionPerformed(evt);
            }
        });
        this.JGRBP0.add(this.JRBNO);
        this.JRBNO.setSelected(true);
        this.JRBNO.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi02.3
            public void actionPerformed(ActionEvent evt) {
                JPAiepi02.this.JRBNOActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setText("Primer episodio de sibilancias:");
        this.JGRBP2.add(this.JRBSIP2);
        this.JRBSIP2.setFont(new Font("Arial", 1, 12));
        this.JRBSIP2.setForeground(Color.red);
        this.JRBSIP2.setText("SI");
        this.JRBSIP2.setHorizontalTextPosition(2);
        this.JRBSIP2.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi02.4
            public void actionPerformed(ActionEvent evt) {
                JPAiepi02.this.JRBSIP2ActionPerformed(evt);
            }
        });
        this.JGRBP2.add(this.JRBNOP2);
        this.JRBNOP2.setFont(new Font("Arial", 1, 12));
        this.JRBNOP2.setForeground(Color.red);
        this.JRBNOP2.setSelected(true);
        this.JRBNOP2.setText("NO");
        this.JRBNOP2.setHorizontalTextPosition(2);
        this.JRBNOP2.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi02.5
            public void actionPerformed(ActionEvent evt) {
                JPAiepi02.this.JRBNOP2ActionPerformed(evt);
            }
        });
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setText("Sibilancias recurrentes:");
        this.JGRBP3.add(this.JRBSIP3);
        this.JRBSIP3.setFont(new Font("Arial", 1, 12));
        this.JRBSIP3.setForeground(Color.red);
        this.JRBSIP3.setText("SI");
        this.JRBSIP3.setHorizontalTextPosition(2);
        this.JRBSIP3.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi02.6
            public void actionPerformed(ActionEvent evt) {
                JPAiepi02.this.JRBSIP3ActionPerformed(evt);
            }
        });
        this.JGRBP3.add(this.JRBNOP3);
        this.JRBNOP3.setFont(new Font("Arial", 1, 12));
        this.JRBNOP3.setForeground(Color.red);
        this.JRBNOP3.setSelected(true);
        this.JRBNOP3.setText("NO");
        this.JRBNOP3.setHorizontalTextPosition(2);
        this.JRBNOP3.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi02.7
            public void actionPerformed(ActionEvent evt) {
                JPAiepi02.this.JRBNOP3ActionPerformed(evt);
            }
        });
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setText("Cuadro gripal últimos 3 días:");
        this.JGRBP4.add(this.JRBSIP4);
        this.JRBSIP4.setFont(new Font("Arial", 1, 12));
        this.JRBSIP4.setForeground(Color.red);
        this.JRBSIP4.setText("SI");
        this.JRBSIP4.setHorizontalTextPosition(2);
        this.JRBSIP4.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi02.8
            public void actionPerformed(ActionEvent evt) {
                JPAiepi02.this.JRBSIP4ActionPerformed(evt);
            }
        });
        this.JGRBP4.add(this.JRBNOP4);
        this.JRBNOP4.setFont(new Font("Arial", 1, 12));
        this.JRBNOP4.setForeground(Color.red);
        this.JRBNOP4.setSelected(true);
        this.JRBNOP4.setText("NO");
        this.JRBNOP4.setHorizontalTextPosition(2);
        this.JRBNOP4.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi02.9
            public void actionPerformed(ActionEvent evt) {
                JPAiepi02.this.JRBNOP4ActionPerformed(evt);
            }
        });
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setText("Antecedente prematuridad:");
        this.JGRBP5.add(this.JRBSIP5);
        this.JRBSIP5.setFont(new Font("Arial", 1, 12));
        this.JRBSIP5.setForeground(Color.red);
        this.JRBSIP5.setText("SI");
        this.JRBSIP5.setHorizontalTextPosition(2);
        this.JRBSIP5.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi02.10
            public void actionPerformed(ActionEvent evt) {
                JPAiepi02.this.JRBSIP5ActionPerformed(evt);
            }
        });
        this.JGRBP5.add(this.JRBNOP5);
        this.JRBNOP5.setFont(new Font("Arial", 1, 12));
        this.JRBNOP5.setForeground(Color.red);
        this.JRBNOP5.setSelected(true);
        this.JRBNOP5.setText("NO");
        this.JRBNOP5.setHorizontalTextPosition(2);
        this.JRBNOP5.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi02.11
            public void actionPerformed(ActionEvent evt) {
                JPAiepi02.this.JRBNOP5ActionPerformed(evt);
            }
        });
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setText("Hace cuanto tiempo?");
        this.JTFDias.setToolTipText("En número");
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setText("días");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel6, -2, 183, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSIP3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP3)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel5, -2, 183, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSIP2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel7, -2, 183, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSIP4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP4)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel8, -2, 183, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSIP5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP5))).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jLabel3, -2, 145, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDias, -2, 47, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel4, -2, 145, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.JTFDias, -2, -1, -2).addComponent(this.jLabel4)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP2, -2, 13, -2).addComponent(this.JRBNOP2, GroupLayout.Alignment.LEADING, -2, 13, -2))).addGap(8, 8, 8).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel6).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP3, -2, 13, -2).addComponent(this.JRBNOP3, GroupLayout.Alignment.LEADING, -2, 13, -2))).addGap(8, 8, 8).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel7).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP4, -2, 13, -2).addComponent(this.JRBNOP4, GroupLayout.Alignment.LEADING, -2, 13, -2))).addGap(8, 8, 8).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel8).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP5, -2, 13, -2).addComponent(this.JRBNOP5, GroupLayout.Alignment.LEADING, -2, 13, -2))).addGap(5, 5, 5)));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 0, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAObservacion);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1, -2, 316, -2).addGap(8, 8, 8).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JRBSI).addGap(10, 10, 10).addComponent(this.JRBNO)).addComponent(this.jLabel2))).addComponent(this.jPanel1, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, 32767).addComponent(this.JSPDiagnosticos, -2, 312, -2)).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDiagnosticos, -2, 188, -2).addGroup(layout.createSequentialGroup().addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBSI).addComponent(this.JRBNO))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2))).addGap(10, 10, 10).addComponent(this.jScrollPane1, -2, 85, -2).addGap(10, 10, 10)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIActionPerformed(ActionEvent evt) {
        this.xP0 = "SI";
        mIniciarElementos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOActionPerformed(ActionEvent evt) {
        this.xP0 = "NO";
        this.xP2 = "NO";
        this.xP3 = "NO";
        this.xP4 = "NO";
        this.xP5 = "NO";
        mIniciarElementos();
        mBuscarTablaDx(this.x);
    }

    private void mIniciarElementos() {
        if (this.JRBSI.isSelected()) {
            this.jPanel1.setEnabled(true);
            this.JTFDias.setEnabled(true);
            this.JRBSIP2.setEnabled(true);
            this.JRBSIP3.setEnabled(true);
            this.JRBSIP4.setEnabled(true);
            this.JRBSIP5.setEnabled(true);
            this.JRBNOP2.setEnabled(true);
            this.JRBNOP3.setEnabled(true);
            this.JRBNOP4.setEnabled(true);
            this.JRBNOP5.setEnabled(true);
            this.JTAObservacion.setEnabled(true);
            return;
        }
        this.jPanel1.setEnabled(false);
        this.JTFDias.setEnabled(false);
        this.JTFDias.setText("");
        this.JRBSIP2.setEnabled(false);
        this.JRBSIP3.setEnabled(false);
        this.JRBSIP4.setEnabled(false);
        this.JRBSIP5.setEnabled(false);
        this.JRBNOP2.setEnabled(false);
        this.JRBNOP3.setEnabled(false);
        this.JRBNOP4.setEnabled(false);
        this.JRBNOP5.setEnabled(false);
        this.JRBNOP2.setSelected(true);
        this.JRBNOP3.setSelected(true);
        this.JRBNOP4.setSelected(true);
        this.JRBNOP5.setSelected(true);
        this.JTAObservacion.setEnabled(false);
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

    public void mGuardar(String xidExamen) {
        String sql = "insert into  `p_aiepi_pb` (`IdEva_AIEPI`, `P0`, `P1`, `P2`,`P3`,`P4`,`P5`,`Observacion`,  `UsuarioS`) values ('" + xidExamen + "', '" + this.xP0 + "', '" + this.JTFDias.getText() + "','" + this.xP2 + "','" + this.xP3 + "','" + this.xP4 + "','" + this.xP5 + "',  '" + this.JTAObservacion.getText() + "',  '" + Principal.usuarioSistemaDTO.getLogin() + "')";
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
